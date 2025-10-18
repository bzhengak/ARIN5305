package minimum_cost_good_caption;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test1");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test2");
        Solution solution0 = new Solution();
        java.lang.Class<?> wildcardClass1 = solution0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test3");
        Solution solution0 = new Solution();
        java.lang.String str2 = solution0.minCostGoodCaption("hi!");
        java.lang.String str4 = solution0.minCostGoodCaption("");
        java.lang.String str6 = solution0.minCostGoodCaption("hhh");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "hhh" + "'", str2, "hhh");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "hhh" + "'", str6, "hhh");
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test4");
        Solution solution0 = new Solution();
        java.lang.String str2 = solution0.minCostGoodCaption("hi!");
        java.lang.String str4 = solution0.minCostGoodCaption("");
        java.lang.Class<?> wildcardClass5 = solution0.getClass();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "hhh" + "'", str2, "hhh");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test5");
        Solution solution0 = new Solution();
        java.lang.String str2 = solution0.minCostGoodCaption("hi!");
        java.lang.String str4 = solution0.minCostGoodCaption("");
        java.lang.String str6 = solution0.minCostGoodCaption("");
        java.lang.String str8 = solution0.minCostGoodCaption("");
        java.lang.Class<?> wildcardClass9 = solution0.getClass();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "hhh" + "'", str2, "hhh");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "" + "'", str6, "");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "" + "'", str8, "");
        org.junit.Assert.assertNotNull(wildcardClass9);
    }
}

