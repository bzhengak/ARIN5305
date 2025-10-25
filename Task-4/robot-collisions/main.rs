#[derive(Debug)]
struct Robot {
    position: i32,
    health: i32,
    direction: char,
    index: usize,
}

impl Solution {
    pub fn survived_robots_healths(positions: Vec<i32>, healths: Vec<i32>, directions: String) -> Vec<i32> {
        let n = positions.len();
        let directions: Vec<char> = directions.chars().collect();
        let mut robots: Vec<Robot> = (0..n)
            .map(|i| Robot {
                position: positions[i],
                health: healths[i],
                direction: directions[i],
                index: i,
            })
            .collect();
        robots.sort_by_key(|x| x.position);
        let mut stack: Vec<usize> = Vec::new();
        let mut result: Vec<Option<i32>> = vec![None; n];
        for i in 0..n {
            if robots[i].direction == 'R' {
                stack.push(i);
                continue;
            }
            let mut current_health = robots[i].health;
            let current_index = robots[i].index;
            while let Some(&last_idx) = stack.last() {
                let last_health = robots[last_idx].health;
                let last_direction = robots[last_idx].direction;
                let last_index = robots[last_idx].index;
                if last_direction != 'R' {
                    break;
                }
                if last_health == current_health {
                    result[last_index] = None;
                    result[current_index] = None;
                    stack.pop();
                    current_health = 0;
                    break;
                } else if last_health > current_health {
                    robots[last_idx].health -= 1;
                    result[current_index] = None;
                    current_health = 0;
                    break;
                } else {
                    result[last_index] = None;
                    stack.pop();
                    current_health -= 1;
                }
            }
            if current_health > 0 {
                result[current_index] = Some(current_health);
            }
        }
        for &idx in &stack {
            result[robots[idx].index] = Some(robots[idx].health);
        }
        result.into_iter().filter_map(|x| x).collect()
    }
}