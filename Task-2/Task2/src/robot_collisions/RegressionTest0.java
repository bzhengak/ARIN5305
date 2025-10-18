package robot_collisions;

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
        int[] intArray5 = new int[] { (short) 1, (short) 10, (-1), 'a' };
        int[] intArray9 = new int[] { '#', (-1), '4' };
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList11 = solution0.survivedRobotsHealths(intArray5, intArray9, "");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 2");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 1, 10, (-1), 97 });
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 35, (-1), 52 });
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test4");
        Solution solution0 = new Solution();
        int[] intArray4 = new int[] { 1, (short) 1, 1 };
        int[] intArray5 = new int[] {};
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList7 = solution0.survivedRobotsHealths(intArray4, intArray5, "");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 0");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] { 1, 1, 1 });
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test5");
        Solution solution0 = new Solution();
        int[] intArray6 = new int[] { 100, 'a', 'a', 'a', (short) 10 };
        int[] intArray7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList9 = solution0.survivedRobotsHealths(intArray6, intArray7, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 4");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 100, 97, 97, 97, 10 });
    }

    @Test
    public void test6() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test6");
        Solution solution0 = new Solution();
        int[] intArray5 = new int[] { (byte) 100, (short) 1, 'a', 'a' };
        Solution solution6 = new Solution();
        int[] intArray10 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray15 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList17 = solution6.survivedRobotsHealths(intArray10, intArray15, "hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList19 = solution0.survivedRobotsHealths(intArray5, intArray15, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 100, 1, 97, 97 });
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertArrayEquals(intArray15, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList17);
    }

    @Test
    public void test7() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test7");
        Solution solution0 = new Solution();
        int[] intArray4 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray9 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList11 = solution0.survivedRobotsHealths(intArray4, intArray9, "hi!");
        Solution solution12 = new Solution();
        int[] intArray16 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray21 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList23 = solution12.survivedRobotsHealths(intArray16, intArray21, "hi!");
        Solution solution24 = new Solution();
        int[] intArray28 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray33 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList35 = solution24.survivedRobotsHealths(intArray28, intArray33, "hi!");
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList37 = solution0.survivedRobotsHealths(intArray21, intArray28, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 3");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList11);
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertArrayEquals(intArray16, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList23);
        org.junit.Assert.assertNotNull(intArray28);
        org.junit.Assert.assertArrayEquals(intArray28, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray33);
        org.junit.Assert.assertArrayEquals(intArray33, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList35);
    }

    @Test
    public void test8() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test8");
        Solution solution0 = new Solution();
        int[] intArray4 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray9 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList11 = solution0.survivedRobotsHealths(intArray4, intArray9, "hi!");
        Solution solution12 = new Solution();
        int[] intArray16 = new int[] { (byte) 100, (byte) 10, (short) 0 };
        int[] intArray21 = new int[] { 100, (byte) -1, (short) 1, (short) 1 };
        java.util.List<java.lang.Integer> intList23 = solution12.survivedRobotsHealths(intArray16, intArray21, "hi!");
        int[] intArray24 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.Integer> intList26 = solution0.survivedRobotsHealths(intArray21, intArray24, "");
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 1");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList11);
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertArrayEquals(intArray16, new int[] { 100, 10, 0 });
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 100, (-1), 1, 1 });
        org.junit.Assert.assertNotNull(intList23);
    }
}

