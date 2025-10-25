use std::collections::HashMap;


impl Solution {
    fn precedence_stack() -> HashMap<char, i32> {
        let mut m = HashMap::new();
        m.insert('(', 0);
        m.insert('+', 2);
        m.insert('-', 2);
        m.insert('*', 4);
        m.insert('/', 4);
        m.insert('n', 5); // 'n' represents 'neg'
        m
    }

    fn precedence_input() -> HashMap<char, i32> {
        let mut m = HashMap::new();
        m.insert('(', 6);
        m.insert(')', 0);
        m.insert('+', 1);
        m.insert('-', 1);
        m.insert('*', 3);
        m.insert('/', 3);
        m.insert('n', 5); // 'n' represents 'neg'
        m
    }

    fn operators() -> Vec<char> {
        vec!['+', '-', '*', '/']
    }

    fn transform(&self, s: String) -> Vec<String> {
        let mut output: Vec<String> = Vec::new();
        let mut s = s;
        s.push(')');
        let mut stack: Vec<char> = vec!['('];
        let mut prev_c = '(';
        let mut has_num = false;
        let mut num = 0;
        for c in s.chars() {
            if c == ' ' {
                continue;
            }
            if c.is_digit(10) {
                has_num = true;
                num = num * 10 + c.to_digit(10).unwrap() as i32;
                prev_c = c;
                continue;
            }
            if has_num {
                has_num = false;
                output.push(num.to_string());
                num = 0;
            }
            let mut current_c = c;
            if c == '-' && (prev_c == '(' || Self::operators().contains(&prev_c)) {
                current_c = 'n';
            }
            while Self::precedence_stack()[stack.last().unwrap()] >= Self::precedence_input()[&current_c] {
                let popped = stack.pop().unwrap();
                if popped != '(' {
                    output.push(popped.to_string());
                } else {
                    break;
                }
            }
            if current_c != ')' {
                stack.push(current_c);
            }
            prev_c = c;
        }
        output
    }

    fn evaluate_postfix(&self, postfix: Vec<String>) -> i32 {
        let mut stack: Vec<i32> = Vec::new();
        for each in postfix {
            if let Ok(num) = each.parse::<i32>() {
                stack.push(num);
                continue;
            }
            match each.as_str() {
                "+" => {
                    let a = stack.pop().unwrap();
                    let b = stack.pop().unwrap();
                    stack.push(a + b);
                }
                "-" => {
                    let a = stack.pop().unwrap();
                    let b = stack.pop().unwrap();
                    stack.push(b - a);
                }
                "*" => {
                    let a = stack.pop().unwrap();
                    let b = stack.pop().unwrap();
                    stack.push(a * b);
                }
                "/" => {
                    let a = stack.pop().unwrap();
                    let b = stack.pop().unwrap();
                    stack.push(b / a);
                }
                "n" => {
                    let a = stack.pop().unwrap();
                    stack.push(-a);
                }
                _ => panic!("Unknown operator"),
            }
        }
        stack[0]
    }

    pub fn calculate(s: String) -> i32 {
        let solution = Solution;
        let postfix = solution.transform(s);
        solution.evaluate_postfix(postfix)
    }
}