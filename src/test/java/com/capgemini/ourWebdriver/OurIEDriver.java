package com.capgemini.ourWebdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dlammers on 2/27/2017.
 * Updated by MInaad on 18/01/2018.
 */
public class OurIEDriver extends InternetExplorerDriver implements OurWebDriver {

    static OurIEDriver browser;

    private OurIEDriver() {
    }

    private OurIEDriver(Capabilities capabilities){
        super(capabilities);
    }

    public static OurIEDriver getBrowser() {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
        if (browser == null || browser.getSessionId() == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("ie.ensureCleanSession", true);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            browser = new OurIEDriver(cap);
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

    public void waitForADF(){
        WebDriverWait wait = new WebDriverWait(browser, IMPLICIT_WAIT_TIMEOUT);
        wait.until(OurExpectedConditions.clientSyncedWithServer());
    }

}
