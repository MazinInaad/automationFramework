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
    public static boolean assertEquals(String expected, String actual, boolean failTest) {
        try {
            Assert.assertEquals(expected, actual);
            return true;
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = getFailHeader(failLocation) + "Expected: " + expected + "\nActual: " + actual;
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertEquals(String expected, String actual) {
        return assertEquals(expected, actual, true);
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
    public static boolean assertEquals(int expected, int actual, boolean failTest) {
        try {
            Assert.assertEquals(expected, actual);
            return true;
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = getFailHeader(failLocation) + "Expected int: " + expected + "\nActual int: " + actual;
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertEquals(int expected, int actual) {
        return assertEquals(expected, actual, true);
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
    public static boolean assertContains(String mainString, String containsString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.contains(containsString));
            return true;
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not contain: " + containsString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertContains(String mainString, String containsString) {
        return assertContains(mainString, containsString, true);
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
    public static boolean assertEndsWith(String mainString, String endsWithString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.endsWith(endsWithString));
            return true;
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not end with " + endsWithString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertEndsWith(String mainString, String endsWithString) {
        return assertEndsWith(mainString, endsWithString, true);
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
    public static boolean assertStartsWith(String mainString, String startsWithString, boolean failTest) {
        try {
            Assert.assertTrue(mainString.startsWith(startsWithString));
            return true;
        } catch (AssertionError e) {
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "String: " + mainString + "\ndoes not start with " + startsWithString);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertStartsWith(String mainString, String startsWithString) {
        return assertStartsWith(mainString, startsWithString, true);
    }

    /**
     * Custom Assert function which tries the assertTrue method from {@link Assert}.
     * If this fails, the fail location is registered (so that it can be printed later)
     * and a screenshot is taken with name 'Assertion_failed_id'.
     *
     * @param assertionMessage
     * @param assertion
     * @param failTest
     */
    public static boolean assertTrue(String assertionMessage, boolean assertion, boolean failTest){
        try {
            Assert.assertTrue(assertion);
            return true;
        }
        catch (AssertionError e){
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + assertionMessage);
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean assertTrue(String assertionMessage, boolean assertion){
        return assertTrue(assertionMessage, assertion, true);
    }
    public static boolean assertTrue(boolean assertion, boolean failTest){
        return assertTrue("Expected 'true', actual 'false'", assertion, failTest);
    }
    public static boolean assertTrue(boolean assertion){
        return assertTrue(assertion, true);
    }

    /**
     * Custom Assert function which verifies that the passed element (By by) is present in the passed OurWebdriver
     * @param browser The driver with which to search for the element
     * @param by The selector for the element
     */
    public static boolean verifyElementpresent(OurWebDriver browser, By by, boolean failTest){
        try{
            Assert.assertTrue(browser.findElements(by).size() > 0);
            return true;
        }
        catch (AssertionError e){
            String failLocation = getTrace(e.getStackTrace());
            String errorMessage = (getFailHeader(failLocation) + "Element: " + by.toString() + "\ndoes not exist.");
            failedAssertions.add(errorMessage);
            OurScenario.takeScreenShot("Assertion_failed_" + failedAssertions.size());
            assertionFailed = true;
            if (failTest)
                Assert.fail("Test has failed due to assertion failure:\n"+errorMessage);
            return false;
        }
    }
    public static boolean verifyElementpresent(OurWebDriver browser, By by){
        return verifyElementpresent(browser, by, true);
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
