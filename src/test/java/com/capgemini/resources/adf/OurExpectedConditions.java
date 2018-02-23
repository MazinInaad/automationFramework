package com.capgemini.resources.adf;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OurExpectedConditions{

    public static ExpectedCondition<Boolean> clientSyncedWithServer() {
        return new ExpectedCondition<Boolean>() {
            // return false if AdfPage object and functions do not exist
            // if they do exist return true if page is fully loaded and ready or reason why this is not completed yet
            public Boolean apply(WebDriver driver) {

                String js =
                        "return typeof AdfPage !== 'undefined' && " +
                                "typeof AdfPage.PAGE !== 'undefined' && " +
                                "typeof AdfPage.PAGE.isSynchronizedWithServer === 'function' && " +
                                "(AdfPage.PAGE.isSynchronizedWithServer() || " +
                                "(typeof AdfPage.PAGE.whyIsNotSynchronizedWithServer === 'function' && " +
                                "AdfPage.PAGE.whyIsNotSynchronizedWithServer()))";

                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                Object result = jsDriver.executeScript(js);
//                System.out.println("client ready: " + result);
                return Boolean.TRUE.equals(result);
            }

            public String toString() {
                return "Waiting for client to sync with server";
            }
        };
    }
}
