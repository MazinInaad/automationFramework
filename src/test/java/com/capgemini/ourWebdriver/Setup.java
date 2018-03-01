package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurScenario;
import com.capgemini.resources.config.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Setup {

    WebDriver browser;

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        browser = BrowserFactory.getWebDriver();
        browser.manage().window().maximize();
        OurScenario.setScenario(scenario);
        String browserType = BrowserFactory.getBrowserType();
        OurScenario.setScenarioPath(scenario.getName() + "\\" + browserType);
        browser.navigate().to(ConfigReader.getProperty("url"));
    }
}
