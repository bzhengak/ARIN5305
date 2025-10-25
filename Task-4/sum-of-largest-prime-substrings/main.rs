impl Solution {
    fn is_prime(n: i64) -> bool {
        if n == 1 {
            return false;
        }
        if n <= 3 {
            return true;
        }
        if n % 2 == 0 || n % 3 == 0 {
            return false;
        }
        let mut i = 5;
        while i * i <= n {
            if n % i == 0 || n % (i + 2) == 0 {
                return false;
            }
            i += 6;
        }
        true
    }

    pub fn sum_of_largest_primes(s: String) -> i64 {
        let mut primes = Vec::new();
        let len = s.len();
        for i in 0..len {
            for j in i..len {
                let v = s[i..=j].parse::<i64>().unwrap();
                if Self::is_prime(v) {
                    primes.push(v);
                }
            }
        }
        primes.sort_by(|a, b| b.cmp(a));
        let mut res = 0;
        let mut prev = -1;
        let mut cnt = 0;
        for &v in primes.iter() {
            if v != prev {
                prev = v;
                res += v;
                cnt += 1;
                if cnt == 3 {
                    break;
                }
            }
        }
        res
    }
}