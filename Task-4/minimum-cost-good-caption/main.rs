use std::collections::HashMap;
use std::cmp::min;



impl Solution {
    pub fn min_cost_good_caption(caption: String) -> String {
        let n = caption.len();
        if n < 3 {
            return String::new();
        }
        
        let mut memo = HashMap::new();
        
        fn get_cost(substring: &str, memo: &mut HashMap<String, (i32, String)>) -> (i32, String) {
            if let Some(res) = memo.get(substring) {
                return res.clone();
            }
            let mut chars: Vec<char> = substring.chars().collect();
            chars.sort();
            let l = chars.len();
            let mc = chars[(l - 1) / 2];
            let target = mc as i32;
            let mut cost = 0;
            for &c in &chars {
                if c == mc {
                    continue;
                }
                cost += (c as i32 - target).abs();
            }
            let s = mc.to_string().repeat(l);
            memo.insert(substring.to_string(), (cost, s.clone()));
            (cost, s)
        }
        
        let mut dp: Vec<Option<(i32, String)>> = vec![None; n + 1];
        
        for i in 3..=min(5, n) {
            let substring = &caption[0..i];
            dp[i] = Some(get_cost(substring, &mut memo));
        }
        
        for i in 6..=n {
            let mut min_cost = i32::MAX;
            let mut best_string = "!".to_string();
            
            for j in 3..=5 {
                if i - j < 3 {
                    continue;
                }
                let substring = &caption[i - j..i];
                let (cost, s) = get_cost(substring, &mut memo);
                if let Some((pre_cost, pre_s)) = &dp[i - j] {
                    let total_cost = cost + pre_cost;
                    if min_cost > total_cost {
                        min_cost = total_cost;
                        best_string = pre_s.clone() + &s;
                    } else if min_cost == total_cost {
                        let candidate = pre_s.clone() + &s;
                        if best_string > candidate {
                            best_string = candidate;
                        }
                    }
                }
            }
            dp[i] = Some((min_cost, best_string));
            if i >= 5 {
                dp[i - 5] = None;
            }
        }
        
        dp[n].as_ref().map_or(String::new(), |(_, s)| s.clone())
    }
}