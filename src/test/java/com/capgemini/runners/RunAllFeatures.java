package com.capgemini.runners;


import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.OurWebDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/project/features/",
        glue = {"com/project/steps/", "com/capgemini/ourWebdriver/"},
        plugin = {"pretty"}
)

public class RunAllFeatures {

    @BeforeClass
    public static void setUp(){}

    @Test
    public void dummy(){}

    @AfterClass
    public static void tearDown(){}
}
