package count_the_number_of_special_characters_ii;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighCoverageTest {

    @Test
    public void testOnlyLowerCase() {
        Solution solution = new Solution();
        // 测试只有小写字母的情况，覆盖Character.isLowerCase分支，但不触发Character.isUpperCase分支
        assertEquals(0, solution.numberOfSpecialChars("abc"));
    }

    @Test
    public void testOnlyUpperCase() {
        Solution solution = new Solution();
        // 测试只有大写字母的情况，覆盖Character.isUpperCase分支，但不触发Character.isLowerCase分支的完整执行
        assertEquals(0, solution.numberOfSpecialChars("ABC"));
    }

    @Test
    public void testSpecialCharsWithMultipleOccurrences() {
        Solution solution = new Solution();
        // 测试特殊字符有多个出现的情况，确保firstUpperCasePos只记录第一次出现
        assertEquals(1, solution.numberOfSpecialChars("aAaA")); // 第一个a在第一个A之前
    }

    @Test
    public void testNoSpecialCharsDespiteMatchingLetters() {
        Solution solution = new Solution();
        // 测试有匹配的字母但不满足位置条件的情况
        assertEquals(0, solution.numberOfSpecialChars("Aa")); // 大写字母在小写字母之前
    }

    @Test
    public void testValidSpecialChars() {
        Solution solution = new Solution();
        // 测试有效的特殊字符情况
        assertEquals(2, solution.numberOfSpecialChars("aAbBcC")); // a<A, b<B, c<C
    }
}