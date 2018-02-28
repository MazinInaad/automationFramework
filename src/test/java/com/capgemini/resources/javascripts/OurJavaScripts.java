package com.capgemini.resources.javascripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OurJavaScripts {

    public static void disableAnimation(WebDriver driver){
        String js = "AdfPage.PAGE.setAnimationEnabled(false)";
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        Object result = jsDriver.executeScript(js);
//        System.out.println("Disable Animation response: " + result);
    }
}
