use std::collections::HashSet;

impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut count = 0;
        let mut seen = HashSet::new();
        let chars: Vec<char> = word.chars().collect();
        let mut last_lower = [usize::MAX; 26];
        let mut first_upper = [usize::MAX; 26];
        
        // First pass: record last occurrence of lowercase and first occurrence of uppercase
        for (i, &c) in chars.iter().enumerate() {
            if c.is_lowercase() {
                let idx = (c as u8 - b'a') as usize;
                last_lower[idx] = i;
            } else {
                let idx = (c as u8 - b'A') as usize;
                if first_upper[idx] == usize::MAX {
                    first_upper[idx] = i;
                }
            }
        }
        
        // Second pass: check conditions
        for i in 0..26 {
            if last_lower[i] != usize::MAX && first_upper[i] != usize::MAX {
                let lower = (b'a' + i as u8) as char;
                let upper = (b'A' + i as u8) as char;
                
                if !seen.contains(&lower) && !seen.contains(&upper) {
                    // Check if all occurrences of lowercase are before first uppercase
                    if last_lower[i] < first_upper[i] {
                        seen.insert(lower);
                        seen.insert(upper);
                        count += 1;
                    }
                }
            }
        }
        
        count
    }
}