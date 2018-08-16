package com.capgemini.ourWebdriver;

import com.capgemini.resources.scenario.OurScenario;
import com.capgemini.resources.config.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

/**
 * Created by MInaad on 26/2/2018.
 */
public class Setup {

    OurWebDriver browser;

    @Before(order = 1)
    public void beforeScenario(Scenario scenario){
        browser = BrowserFactory.getWebDriver();
        browser.manage().window().maximize();
        OurScenario.setScenario(scenario);
        browser.get(ConfigReader.getProperty("url"));
    }
}
