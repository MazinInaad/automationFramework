package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurScenario;
import com.capgemini.resources.config.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Setup {

    OurWebDriver browser;

    @Before
    public void beforeScenario(Scenario scenario){
        browser = BrowserFactory.getWebDriver();
        browser.manage().window().maximize();
        OurScenario.setScenario(scenario);
        browser.get(ConfigReader.getProperty("url"));
    }
}
