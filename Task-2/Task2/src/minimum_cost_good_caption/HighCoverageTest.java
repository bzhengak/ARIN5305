package minimum_cost_good_caption;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighCoverageTest {

    @Test
    public void testShortCaption() {
        Solution solution = new Solution();
        // 测试长度小于3的字符串
        assertEquals("", solution.minCostGoodCaption("ab"));
    }

    @Test
    public void testExactlyThreeChars() {
        Solution solution = new Solution();
        // 测试恰好3个字符的字符串
        assertEquals("aaa", solution.minCostGoodCaption("bcd"));
    }

    @Test
    public void testSevenChars() {
        Solution solution = new Solution();
        // 测试7个字符（可以分解为3+4）
        assertEquals("aaaaaaa", solution.minCostGoodCaption("bcdefgh"));
    }

    @Test
    public void testTwelveChars() {
        Solution solution = new Solution();
        // 测试12个字符（可以分解为3+4+5或其它组合）
        assertEquals("aaaaaaaaaaaa", solution.minCostGoodCaption("bcdefghijklm"));
    }

    @Test
    public void testOptimalSegmentation() {
        Solution solution = new Solution();
        // 测试不同分段长度的选择
        // 构造一个例子，使得长度为4的分段比其他选项更优
        assertEquals("bbbbbbbb", solution.minCostGoodCaption("aaaacccc"));
    }
}