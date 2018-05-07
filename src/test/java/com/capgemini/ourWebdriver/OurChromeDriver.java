package com.capgemini.ourWebdriver;

import com.capgemini.resources.javascripts.OurJavaScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by dlammers on 27/2/2017.
 * Updated by MInaad on 18/12/2017.
 */
public class OurChromeDriver extends ChromeDriver implements OurWebDriver {

    static OurChromeDriver browser;

    private OurChromeDriver(ChromeOptions options) {
        super(options);
    }

    public static OurChromeDriver getBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        if (browser == null || browser.getSessionId() == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (BrowserFactory.getBrowserType().equals("chrome")) {
                chromeOptions.addArguments("incognito");
            }
            else {
                Map<String, String> mobileEmulation = new HashMap<String, String>();
                mobileEmulation.put("deviceName", BrowserFactory.getBrowserType());
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            }
            browser = new OurChromeDriver(chromeOptions);
        }
        return browser;
    }

    public WebElement waitForElement(String selector) {
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForVisible(String selector) {
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    public WebElement waitForVisible(By by) {
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void scrollToElement(WebElement element) {
        browser.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForAjax() {
        WebDriverWait webDriverWait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        webDriverWait.until(OurExpectedConditions.jQueryIsInactive());
    }

    public void waitForADF(){
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(OurExpectedConditions.clientSyncedWithServer());
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(OurExpectedConditions.documentStateComplete());
    }

    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForInvisible(By by){
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void disableAnimation() {
        browser.executeScript(OurJavaScripts.getDisableAnimationScript());
    }

    public WebElement hover(By by) {
        WebElement element = browser.findElement(by);
        return hover(element);
    }

    public WebElement hover(WebElement element) {
        browser.executeScript(OurJavaScripts.getMouseOverScript(),element);
        return element;
    }
}
