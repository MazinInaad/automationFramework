package com.capgemini.ourWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by DLAMMERS on 24/1/2017.
 * Updated by MInaad on 26/2/2018
 */
public interface OurWebDriver extends WebDriver {

    int IMPLICIT_WAIT_TIMEOUT = 60;


    WebElement waitForElement(String selector);
    WebElement waitForElement(By by);

    WebElement waitForVisible(String selector);
    WebElement waitForVisible(By by);
    void scrollToElement(WebElement element);

    void waitForAjax();

    void waitForAlert();

    void waitForInvisible(By by);

    void disableAnimation();

    void waitForADF();

    WebElement hover(By by);

    WebElement hover(WebElement element);
}
