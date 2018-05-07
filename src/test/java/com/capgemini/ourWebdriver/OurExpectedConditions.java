package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by MInaad on 26/2/2018.
 */
public class OurExpectedConditions{

    public static ExpectedCondition<Boolean> clientSyncedWithServer() {
        return new ExpectedCondition<Boolean>() {
            // return false if AdfPage object and functions do not exist
            // if they do exist return true if page is fully loaded and ready or reason why this is not completed yet
            int retyrCounter = 1;
            public Boolean apply(WebDriver driver) {

                String js =
                        "return typeof AdfPage !== 'undefined' && " +
                                "typeof AdfPage.PAGE !== 'undefined' && " +
                                "typeof AdfPage.PAGE.isSynchronizedWithServer === 'function' && " +
                                "(AdfPage.PAGE.isSynchronizedWithServer() || " +
                                "(typeof AdfPage.PAGE.whyIsNotSynchronizedWithServer === 'function' && " +
                                "AdfPage.PAGE.whyIsNotSynchronizedWithServer()))";

                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                Object result = null;
                try {
                    result = jsDriver.executeScript(js);
                }
                catch(JavascriptException e){
                    System.out.println("org.openqa.selenium.JavascriptException: JavaScript error");
                    System.out.println(OurAssertions.getTrace(e.getStackTrace()));
                    if (retyrCounter<4){
                        System.out.println("Retrying: attempt "+retyrCounter);
                        return apply(driver);
                    }
                }
//                System.out.println("client ready: " + result);
                return Boolean.TRUE.equals(result);
            }

            public String toString() {
                return "Waiting for client to sync with server";
            }
        };
    }

    public static ExpectedCondition<Boolean> jQueryIsInactive(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String js =
                        "return jQuery.active == 0;";

                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                Object result = jsDriver.executeScript(js);
                return Boolean.TRUE.equals(result);
            }
        };
    }

    public static ExpectedCondition<Boolean> documentStateComplete(){
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                String js =
                        "return document.readyState;";

                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                Object result = jsDriver.executeScript(js);
                return result.toString().equals("complete");
            }
        };
    }
}
