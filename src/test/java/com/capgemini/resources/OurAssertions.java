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

    public OurAssertions() {
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
    public static void assertEquals(String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "Expected: " + expected + "\nActual: " + actual);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
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
    public static void assertEquals(int expected, int actual) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "Expected int: " + expected + "\nActual int: " + actual);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
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
    public static void assertContains(String mainString, String containsString) {
        try {
            Assert.assertTrue(mainString.contains(containsString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "String: " + mainString + "\ndoes not contain: " + containsString);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
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
    public static void assertEndsWith(String mainString, String endsWithString) {
        try {
            Assert.assertTrue(mainString.endsWith(endsWithString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "String: " + mainString + "\ndoes not end with " + endsWithString);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
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
    public static void assertStartsWith(String mainString, String startsWithString) {
        try {
            Assert.assertTrue(mainString.startsWith(startsWithString));
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "String: " + mainString + "\ndoes not start with " + startsWithString);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
    }

    /**
     * Custom Assert function which verifies that the passed element (By by) is present in the passed OurWebdriver
     * @param browser The driver with which to search for the element
     * @param by The selector for the element
     */
    public static void verifyElementpresent(OurWebDriver browser, By by){
        try{
            Assert.assertTrue(browser.findElements(by).size() > 0);
        }
        catch (AssertionError e){
            String failLocation = getTrace(e.getStackTrace());
            failedAssertions.add(getFailHeader(failLocation) + "Element: " + by.toString() + "\ndoes not exist.");
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
        }
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
        return "---Scenario: \"" + OurScenario.getScenario().getName() + "\"---\nFailed assertion (" + (failedAssertions.size() + 1) + ") at \n" + failLocation + "\n";
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
