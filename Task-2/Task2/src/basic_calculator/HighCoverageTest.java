package basic_calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighCoverageTest {

    @Test
    public void testMultiDigitNumbers() {
        Solution solution = new Solution();
        // 测试多位数和减法
        assertEquals(123, solution.calculate("123"));
    }

    @Test
    public void testNegativeResult() {
        Solution solution = new Solution();
        // 测试负数结果
        assertEquals(-2, solution.calculate("1 - 3"));
    }

    @Test
    public void testNestedParenthesesWithSign() {
        Solution solution = new Solution();
        // 测试嵌套括号和负号
        assertEquals(0, solution.calculate("-(1+(2)) + 3"));
    }

    @Test
    public void testComplexExpression() {
        Solution solution = new Solution();
        // 测试复杂表达式
        assertEquals(-11, solution.calculate("(1-(1+2)) - (5+3)"));
    }

    @Test
    public void testSimpleExpression() {
        Solution solution = new Solution();
        // 测试简单表达式
        assertEquals(2, solution.calculate("1 + 1"));
    }
}