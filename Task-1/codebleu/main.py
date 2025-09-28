#!/usr/bin/env python3
"""
修正版CodeBLEU相似性计算工具
Task 1.2: Code Similarity Measure
解决CodeBLEU未定义错误，提供完整的代码相似度计算
"""

import os
import json
import pandas as pd
import numpy as np
from nltk.translate.bleu_score import sentence_bleu, SmoothingFunction
import ast
from tree_sitter import Language, Parser
import subprocess
import sys

def install_required_packages():
    """安装必要的依赖包"""
    required_packages = [
        'nltk>=3.6.0',
        'tree-sitter>=0.20.0',
        'pandas>=1.3.0',
        'numpy>=1.21.0'
    ]
    
    for package in required_packages:
        try:
            subprocess.check_call([sys.executable, '-m', 'pip', 'install', package.split('>=')[0]])
            print(f"成功安装: {package}")
        except subprocess.CalledProcessError as e:
            print(f"安装失败 {package}: {e}")

def setup_nltk():
    """设置NLTK必要的数据"""
    try:
        import nltk
        nltk.download('punkt', quiet=True)
        print("NLTK设置完成")
    except Exception as e:
        print(f"NLTK设置错误: {e}")

class CodeBLEUCalculator:
    """
    自定义CodeBLEU计算器
    基于论文实现：CodeBLEU: A Method for Automatic Evaluation of Code Synthesis
    """
    
    def __init__(self):
        self.setup_tree_sitter()
        self.weights = (0.25, 0.25, 0.25, 0.25)  # BLEU权重
    
    def setup_tree_sitter(self):
        """设置Tree-sitter语法解析器"""
        try:
            # 尝试加载Java语法
            Language.build_library(
                'build/languages.so',
                ['vendor/tree-sitter-java']
            )
            self.java_language = Language('build/languages.so', 'java')
            self.parser = Parser()
            self.parser.set_language(self.java_language)
        except Exception as e:
            print(f"Tree-sitter设置警告: {e}")
            self.parser = None
    
    def calculate_bleu(self, reference, candidate):
        """计算传统BLEU分数[6,7](@ref)"""
        try:
            # 将代码分割成token
            ref_tokens = reference.split()
            cand_tokens = candidate.split()
            
            # 使用平滑函数处理零匹配情况
            smoothing_function = SmoothingFunction().method1
            
            score = sentence_bleu(
                [ref_tokens], 
                cand_tokens,
                weights=self.weights,
                smoothing_function=smoothing_function
            )
            return score
        except Exception as e:
            print(f"BLEU计算错误: {e}")
            return 0.0
    
    def calculate_syntax_match(self, reference, candidate):
        """计算语法结构匹配度"""
        if not self.parser:
            return 0.0
        
        try:
            # 解析AST
            ref_tree = self.parser.parse(bytes(reference, 'utf8'))
            cand_tree = self.parser.parse(bytes(candidate, 'utf8'))
            
            # 简化的AST节点类型匹配
            ref_nodes = self.get_ast_nodes(ref_tree)
            cand_nodes = self.get_ast_nodes(cand_tree)
            
            if not ref_nodes or not cand_nodes:
                return 0.0
            
            # 计算节点类型匹配度
            common_nodes = set(ref_nodes) & set(cand_nodes)
            match_score = len(common_nodes) / len(set(ref_nodes))
            return match_score
        except Exception as e:
            print(f"语法匹配计算错误: {e}")
            return 0.0
    
    def get_ast_nodes(self, tree):
        """提取AST节点类型"""
        nodes = []
        
        def traverse(node):
            if node.type:
                nodes.append(node.type)
            for child in node.children:
                traverse(child)
        
        traverse(tree.root_node)
        return nodes
    
    def calculate_keyword_match(self, reference, candidate):
        """计算关键词匹配度"""
        try:
            # Java关键词列表
            java_keywords = {
                'public', 'private', 'protected', 'class', 'interface', 'void', 
                'int', 'boolean', 'String', 'if', 'else', 'for', 'while', 'return',
                'new', 'this', 'static', 'final', 'import', 'package'
            }
            
            ref_keywords = [word for word in reference.split() if word in java_keywords]
            cand_keywords = [word for word in candidate.split() if word in java_keywords]
            
            if not ref_keywords:
                return 0.0
            
            common_keywords = set(ref_keywords) & set(cand_keywords)
            match_score = len(common_keywords) / len(set(ref_keywords))
            return match_score
        except Exception as e:
            print(f"关键词匹配计算错误: {e}")
            return 0.0
    
    def calculate_dataflow_match(self, reference, candidate):
        """简化的数据流匹配度计算"""
        try:
            # 提取变量名和基本操作
            ref_vars = self.extract_variables(reference)
            cand_vars = self.extract_variables(candidate)
            
            if not ref_vars:
                return 0.0
            
            common_vars = set(ref_vars) & set(cand_vars)
            match_score = len(common_vars) / len(set(ref_vars))
            return match_score
        except Exception as e:
            print(f"数据流匹配计算错误: {e}")
            return 0.0
    
    def extract_variables(self, code):
        """提取代码中的变量名"""
        variables = []
        lines = code.split('\n')
        
        for line in lines:
            words = line.split()
            for i, word in enumerate(words):
                # 简单的变量识别规则
                if word in ['int', 'String', 'boolean', 'char', 'double', 'float']:
                    if i + 1 < len(words):
                        next_word = words[i + 1]
                        if next_word.endswith(';'):
                            next_word = next_word[:-1]
                        variables.append(next_word)
                elif '=' in word and not word.startswith('='):
                    var_name = word.split('=')[0].strip()
                    variables.append(var_name)
        
        return variables
    
    def score(self, candidate, references):
        """
        计算综合CodeBLEU分数[1,7](@ref)
        参考论文中的权重分配：BLEU + 语法匹配 + 关键词匹配 + 数据流匹配
        """
        if isinstance(references, str):
            references = [references]
        
        # 计算各个组件分数
        bleu_scores = []
        for ref in references:
            bleu_score = self.calculate_bleu(ref, candidate)
            bleu_scores.append(bleu_score)
        
        avg_bleu = max(bleu_scores) if bleu_scores else 0.0
        syntax_score = self.calculate_syntax_match(references[0], candidate)
        keyword_score = self.calculate_keyword_match(references[0], candidate)
        dataflow_score = self.calculate_dataflow_match(references[0], candidate)
        
        # 综合分数（根据论文权重调整）
        final_score = (
            0.4 * avg_bleu + 
            0.3 * syntax_score + 
            0.2 * keyword_score + 
            0.1 * dataflow_score
        )
        
        return final_score

def load_java_files(directory_path):
    """加载Java文件内容"""
    code_dict = {}
    if not os.path.exists(directory_path):
        print(f"警告: 目录 {directory_path} 不存在")
        return code_dict
        
    for filename in os.listdir(directory_path):
        if filename.endswith('.java'):
            problem_name = filename.replace('.java', '')
            file_path = os.path.join(directory_path, filename)
            try:
                with open(file_path, 'r', encoding='utf-8') as f:
                    code_dict[problem_name] = f.read()
            except Exception as e:
                print(f"读取文件 {file_path} 时出错: {e}")
                code_dict[problem_name] = ""
    return code_dict

def main():
    """主函数：计算所有问题的CodeBLEU相似度"""
    
    # 安装必要依赖
    print("正在安装必要依赖...")
    install_required_packages()
    setup_nltk()
    
    # 定义路径
    base_dir = "resource"
    correct_dir = os.path.join(base_dir, "correctJavaPrograms")
    llm_dir = os.path.join(base_dir, "llmGeneratedPrograms") 
    faulty_dir = os.path.join(base_dir, "faultyJavaProgramsToCompare")
    
    # 创建结果目录
    os.makedirs("results", exist_ok=True)
    
    # 初始化CodeBLEU计算器
    print("初始化CodeBLEU计算器...")
    codebleu_calc = CodeBLEUCalculator()
    
    # 加载所有代码文件
    print("正在加载代码文件...")
    correct_codes = load_java_files(correct_dir)
    llm_codes = load_java_files(llm_dir)
    faulty_codes = load_java_files(faulty_dir)
    
    # 获取所有问题名称
    problems = sorted(correct_codes.keys())
    print(f"找到 {len(problems)} 个问题: {problems}")
    
    results = []
    
    # 对每个问题计算相似度
    for problem in problems:
        print(f"\n正在处理问题: {problem}")
        
        if problem not in correct_codes:
            print(f"跳过 {problem}: 无正确代码")
            continue
            
        correct_code = correct_codes[problem]
        
        # 计算正确代码 vs LLM生成代码
        llm_score = 0.0
        if problem in llm_codes and llm_codes[problem].strip():
            llm_score = codebleu_calc.score(llm_codes[problem], [correct_code])
            print(f"  Correct vs LLM: {llm_score:.4f}")
        else:
            print(f"  {problem} 无LLM生成代码")
        
        # 计算正确代码 vs 错误代码
        faulty_score = 0.0
        if problem in faulty_codes and faulty_codes[problem].strip():
            faulty_score = codebleu_calc.score(faulty_codes[problem], [correct_code])
            print(f"  Correct vs Faulty: {faulty_score:.4f}")
        else:
            print(f"  {problem} 无错误代码")
        
        results.append({
            'problem': problem,
            'correct_vs_llm': llm_score,
            'correct_vs_faulty': faulty_score,
            'score_difference': llm_score - faulty_score
        })
    
    # 保存结果到CSV
    df = pd.DataFrame(results)
    output_file = "results/similarity_scores.csv"
    df.to_csv(output_file, index=False)
    
    print(f"\n计算完成！结果已保存到: {output_file}")
    
    # 打印汇总统计
    print("\n=== 汇总统计 ===")
    print(f"平均 Correct vs LLM 分数: {df['correct_vs_llm'].mean():.4f}")
    print(f"平均 Correct vs Faulty 分数: {df['correct_vs_faulty'].mean():.4f}")
    print(f"平均分数差异: {df['score_difference'].mean():.4f}")
    
    # 保存详细结果到JSON
    with open("results/detailed_results.json", 'w') as f:
        json.dump(results, f, indent=2)
    

if __name__ == "__main__":
    main()