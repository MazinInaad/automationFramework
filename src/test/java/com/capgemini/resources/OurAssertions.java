package com.capgemini.resources;


import junit.framework.AssertionFailedError;
import org.junit.Assert;

import java.io.IOException;
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
     * @throws IOException
     * @see Assert
     */
    public static void assertEquals(String expected, String actual) throws IOException {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionFailedError e) {
            String failLocation = getTrace(e);
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
     * @throws IOException
     * @see Assert
     */
    public static void assertEquals(int expected, int actual) throws IOException {
        try {
            Assert.assertEquals(expected, actual);
        } catch (AssertionFailedError e) {
            String failLocation = getTrace(e);
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
     * @throws IOException
     * @see Assert
     */
    public static void assertContains(String mainString, String containsString) throws IOException {
        try {
            Assert.assertTrue(mainString.contains(containsString));
        } catch (AssertionFailedError e) {
            String failLocation = getTrace(e);
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
     * @throws IOException
     * @see Assert
     */
    public static void assertEndsWith(String mainString, String endsWithString) throws IOException {
        try {
            Assert.assertTrue(mainString.endsWith(endsWithString));
        } catch (AssertionFailedError e) {
            String failLocation = getTrace(e);
            failedAssertions.add(getFailHeader(failLocation) + "String: " + mainString + "\ndoes not end with " + endsWithString);
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

    private static String getTrace(AssertionFailedError e) {
        String returnString = "";
        StackTraceElement[] stack = e.getStackTrace();
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
