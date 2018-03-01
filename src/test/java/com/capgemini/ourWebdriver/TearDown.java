package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurAssertions;
import com.capgemini.resources.OurScenario;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class TearDown {

    WebDriver browser;

    public TearDown() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();
    }


    @After
        Thread.sleep(0*1000);
    public void afterScenario(Scenario scenario) throws InterruptedException{
        if(scenario.isFailed()){
            OurScenario.takeScreenShot("TestFail");
            Thread.sleep(5*1000);
        }
        browser.quit();

        OurAssertions.printAssertions();
        if (OurAssertions.isAssertionFailed()) {
            Assert.fail();
        }
    }
}
