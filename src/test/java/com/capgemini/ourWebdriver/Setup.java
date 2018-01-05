package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurScenario;
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
    }
}
