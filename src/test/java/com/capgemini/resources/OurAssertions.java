package com.capgemini.resources;


import com.capgemini.ourWebdriver.OurWebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;

/**
 * Created by MINAAD on 23-11-2017.
 */
public class OurAssertions {

    private static ArrayList<String> failedAssertions = new ArrayList<String>();
    private static boolean assertionFailed = false;

    public static void resetAssertions(){
        failedAssertions = new ArrayList<String>();
        assertionFailed = false;
    }

    /**
     * Custom Assert function which tries the assertEquals method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken.
     *
     * @param expected The expected value of the String
     * @param actual The String to be tested
     * @see Assert
     */
    public static void assertEquals(String expected, String actual, boolean failTest) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = getFailHeader(failLocation) + "Expected: " + expected + "\nActual: " + actual;
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void assertEquals(String expected, String actual) {
        assertEquals(expected, actual, false);
    }


    /**
     * Custom Assert function which tries the assertEquals method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken.
     *
     * @param expected The expected value of the int
     * @param actual The int to be tested
     * @see Assert
     */
    public static void assertEquals(int expected, int actual, boolean failTest) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = getFailHeader(failLocation) + "Expected int: " + expected + "\nActual int: " + actual;
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void assertEquals(int expected, int actual) {
        assertEquals(expected, actual, false);
    }

    /**
     * Custom Assert function which tries the assertTrue method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken.
     *
     * @param mainString The string to be tested
     * @param containsString The substring which the test string should contain
     * @see Assert
     */
    public static void assertContains(String mainString, String containsString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.contains(containsString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not contain: " + containsString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void assertContains(String mainString, String containsString) {
        assertContains(mainString, containsString, false);
    }

    /**
     * Custom Assert function which tries the assertTrue method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken with name 'Assertion_failed_id'.
     *
     * @param mainString The String to be tested
     * @param endsWithString The substring which the test string should end with
     * @see Assert
     */
    public static void assertEndsWith(String mainString, String endsWithString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.endsWith(endsWithString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not end with " + endsWithString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void assertEndsWith(String mainString, String endsWithString) {
        assertEndsWith(mainString, endsWithString, false);
    }

    /**
     * Custom Assert function which tries the assertTrue method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken with name 'Assertion_failed_id'.
     *
     * @param mainString The String to be tested
     * @param startsWithString The substring which the test string should end with
     * @see Assert
     */
    public static void assertStartsWith(String mainString, String startsWithString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.startsWith(startsWithString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not start with " + startsWithString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void assertStartsWith(String mainString, String startsWithString) {
        assertStartsWith(mainString, startsWithString, false);
    }

    /**
     * Custom Assert function which verifies that the passed element (By by) is present in the passed OurWebdriver
     * @param browser The driver with which to search for the element
     * @param by The selector for the element
     */
    public static void verifyElementpresent(OurWebDriver browser, By by, boolean failTest){
        try{
            Assert.assertTrue(browser.findElements(by).size() > 0);
        }
        catch (AssertionError e){
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "Element: " + by.toString() + "\ndoes not exist.");
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
        }
    }
    public static void verifyElementpresent(OurWebDriver browser, By by){
        verifyElementpresent(browser, by, false);
    }

    /**
     * If there are failed Assertions, this method prints to the console the following information:
     *  - The scenario name
     *  - The identifying number of the Assertion which corresponds to the name of the screenshot of the failed Assertion
     *  - The line number of the java method in the steps file at which the Assertion was called.
     *  - Description of the failed assertion
     */
    public static void printAssertions() {
        for (String failedAssert : failedAssertions) {
            System.out.println(failedAssert);
        }
    }

    public static boolean isAssertionFailed() {
        return assertionFailed;
    }


    private static String getFailHeader(String failLocation) {
        return "---Scenario: \"" + OurScenario.getScenarioName() + "\"---\nFailed assertion (" + (failedAssertions.size() + 1) + ") at \n" + failLocation + "\n";
    }

    public static String getTrace(StackTraceElement[] stack) {
        String returnString = "";
        for (StackTraceElement trace : stack) {
            if (trace.toString().contains("com.project.")) {
                returnString += trace.toString() + "\n";
            }
        }
        if (returnString.equals(""))
            return "unknown";
        else
            return returnString;
    }
}
