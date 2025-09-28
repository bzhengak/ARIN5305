# CodeBLEU Similarity Calculator

## Overview
This tool calculates CodeBLEU similarity scores between Java code files. CodeBLEU is an automated evaluation metric specifically designed for code synthesis tasks, incorporating code-specific features like abstract syntax tree (AST) matching and data flow analysis [1](@ref).

## Installation

### Prerequisites
- Python 3.8 or higher
- pip package manager

### Required Libraries
Install the required dependencies using:
bash
pip install -r requirements.txt
The `requirements.txt` file includes:
nltk>=3.6.0
tree-sitter>=0.20.0
pandas>=1.3.0
numpy>=1.21.0
### Additional Setup
After installation, run the following to download necessary NLTK data:
python
import nltk
nltk.download('punkt')
## Usage

### File Structure Preparation
Organize code files in the following structure:
resource/
├── correctJavaPrograms/
│ ├── basic-calculator.java
│ ├── count-the-number-of-special-characters-ii.java
│ ├── minimum-cost-good-caption.java
│ ├── robot-collisions.java
│ └── sum-of-largest-prime-substrings.java
├── llmGeneratedPrograms/
│ ├── basic-calculator.java
│ ├── count-the-number-of-special-characters-ii.java
│ ├── minimum-cost-good-caption.java
│ ├── robot-collisions.java
│ └── sum-of-largest-prime-substrings.java
└── faultyJavaProgramsToCompare/
│ ├── basic-calculator.java
│ ├── count-the-number-of-special-characters-ii.java
│ ├── minimum-cost-good-caption.java
│ ├── robot-collisions.java
│ └── sum-of-largest-prime-substrings.java
### Running the Calculation
Execute the main script to compute CodeBLEU similarities:
bash
python calculate_codebleu.py
### Output
The tool generates the following results in the `results/` directory:
- `similarity_scores.csv`: CodeBLEU scores for all problem comparisons
- `detailed_results.json`: Detailed results in JSON format

## Output Interpretation

### CodeBLEU Score Range
- **0.0-0.3**: Low similarity
- **0.3-0.6**: Moderate similarity  
- **0.6-0.8**: High similarity
- **0.8-1.0**: Very high similarity

### Important Notes
- CodeBLEU measures structural and syntactic similarity, not functional correctness
- Higher scores indicate greater code structure similarity, but not necessarily better functionality
- Use scores as one indicator among multiple evaluation methods
- Results should be interpreted in context of specific programming problems

## Example Output
Problem: basic-calculator
Correct vs LLM: 0.3443
Correct vs Faulty: 0.6883
## Troubleshooting

### Common Issues
1. **File Not Found Errors**: Ensure all Java files are in the correct directories with proper naming
2. **Encoding Issues**: Java files should use UTF-8 encoding
3. **Dependency Errors**: Try reinstalling requirements or using a virtual environment

### Getting Help
For additional support, refer to the original CodeBLEU paper [1](@ref) or check the example implementations.

## References
- CodeBLEU Original Paper: [arXiv:2009.10297](https://arxiv.org/abs/2009.10297)
- CodeBLEU extends traditional BLEU with code-specific features [1](@ref)
- Combination of n-gram, AST, and data flow matching [3](@ref)