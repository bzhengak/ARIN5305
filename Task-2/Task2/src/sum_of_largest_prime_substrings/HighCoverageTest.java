package sum_of_largest_prime_substrings;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighCoverageTest {

    @Test
    public void testIsPrimeSpecialNonPrimes() {
        Solution solution = new Solution();
        // 测试isPrime方法中特殊非质数(0,1,4)的处理分支
        assertEquals(0, solution.sumOfLargestPrimes("014"));
    }

    @Test
    public void testIsPrimeSmallPrimes() {
        Solution solution = new Solution();
        // 测试isPrime方法中特殊质数(2,3)的处理分支
        assertEquals(5, solution.sumOfLargestPrimes("23"));
    }

    @Test
    public void testIsPrimeFullLogic() {
        Solution solution = new Solution();
        // 测试isPrime方法中完整质数检测逻辑(循环和整除判断)
        assertEquals(101, solution.sumOfLargestPrimes("1019"));
        // 101和19都是质数，需要完整质数检测过程
    }

    @Test
    public void testEvenDigitSkippingLogic() {
        Solution solution = new Solution();
        // 测试偶数跳过逻辑(s.charAt(j)%2==0 && i!=j)
        assertEquals(2, solution.sumOfLargestPrimes("2468"));
        // 只有2是质数，其他偶数都不是质数，多位数以偶数结尾会被跳过
    }

    @Test
    public void testAllRankingBranches() {
        Solution solution = new Solution();
        // 测试所有排名条件分支(p1,p2,p3更新的所有分支)
        assertEquals(131, solution.sumOfLargestPrimes("1131"));
        // 包含质数11, 31, 113等，确保所有排名分支都被触发
        // 包括：新数字成为最大值、第二大值、第三大值的情况
    }
}