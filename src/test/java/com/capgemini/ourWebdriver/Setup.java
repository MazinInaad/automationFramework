package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurScenario;
import com.capgemini.resources.config.ConfigReader;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

import java.io.UnsupportedEncodingException;

public class Setup {

    OurWebDriver browser;

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) throws UnsupportedEncodingException {
        browser = BrowserFactory.getWebDriver();
        browser.manage().window().maximize();
        OurScenario.setScenario(scenario);
        browser.get(ConfigReader.getProperty("url"));
        Reporter.getExtentReport().setGherkinDialect("nl");
    }
}
