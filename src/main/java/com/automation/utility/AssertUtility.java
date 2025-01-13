package com.automation.utility;

import org.testng.Assert;

public class AssertUtility {

    public static void assertEquals(Object actual, Object expected, Object value) {
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("Assert value of " + value + "-: \n" + actual + " \nequals: \n" + expected);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertContains(String actual, String expected, String value) {
        try {
            Assert.assertTrue(actual.contains(expected));
        } catch (AssertionError e) {
            System.out.println("Assert value of " + value + " - " + actual + " equals " + expected);
            Assert.fail("Assertion Failed: " + e.getMessage());
        }
    }
}
