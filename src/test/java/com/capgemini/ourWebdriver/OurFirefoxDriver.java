package com.capgemini.ourWebdriver;

import com.capgemini.resources.javascripts.OurJavaScripts;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dlammers on 27/2/2017.
 * Updated by MInaad on 27/2/2018.
 */
public class OurFirefoxDriver extends FirefoxDriver implements OurWebDriver {

    static OurFirefoxDriver browser;

    private OurFirefoxDriver() {
    }

    public OurFirefoxDriver(Capabilities desiredCapabilities) {
        super(desiredCapabilities);
    }

    public static OurFirefoxDriver getBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        if (browser == null || browser.getSessionId() == null) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            DesiredCapabilities caps = DesiredCapabilities.firefox();
            caps.setCapability(FirefoxDriver.PROFILE, profile);
            browser = new OurFirefoxDriver(caps);
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
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForAjax() {
        WebDriverWait webDriverWait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String scriptToExecute =
                        "return jQuery.active == 0;";
                Boolean ajaxDone = Boolean.valueOf(((JavascriptExecutor) driver).executeScript(scriptToExecute).toString());
                return ajaxDone ? true : null;
            }
        });
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

    public void waitForADF(){
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(OurExpectedConditions.clientSyncedWithServer());
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
