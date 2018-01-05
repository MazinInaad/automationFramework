package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurAssertions;
import com.capgemini.resources.OurScenario;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class TearDown {

    WebDriver browser;

    public TearDown() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();
    }


    @After
    public void afterScenario(Scenario scenario) throws InterruptedException, IOException {
        Thread.sleep(0*1000);
        if(scenario.isFailed()){
            OurScenario.takeScreenShot("TestFail");
            Thread.sleep(15*1000);
        }
        browser.quit();

        OurAssertions.printAssertions();
        if (OurAssertions.isAssertionFailed()) {
            Assert.fail();
        }
    }
}
