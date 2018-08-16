package com.capgemini.ourWebdriver;

import com.capgemini.resources.assertions.OurAssertions;
import com.capgemini.resources.scenario.OurScenario;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.Assert;

/**
 * Created by MInaad on 26/2/2018.
 */
public class TearDown {

    OurWebDriver browser;

    @After
    public void afterScenario(Scenario scenario){
        browser = BrowserFactory.getWebDriver();
        if(scenario.isFailed()){
            OurScenario.takeScreenShot("TestFail");
        }
        browser.quit();

        OurAssertions.printAssertions();
        if (OurAssertions.isAssertionFailed()) {
            Assert.fail();
        }
    }
}
