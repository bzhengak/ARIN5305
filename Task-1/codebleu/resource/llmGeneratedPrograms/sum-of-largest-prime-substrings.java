import java.util.HashSet;
import java.util.Set;

class Solution {
    public long sumOfLargestPrimes(String s) {
        Set<Long> primes = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n && j <= i + 10; j++) { // assuming max substring length for primes is 10 digits
                String substring = s.substring(i, j);
                if (substring.length() > 1 && substring.charAt(0) == '0') {
                    continue; // skip numbers with leading zero
                }
                long num = Long.parseLong(substring);
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
        }
        return primes.stream().sorted((a, b) -> Long.compare(b, a)).limit(3).mapToLong(Long::longValue).sum();
    }

    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}