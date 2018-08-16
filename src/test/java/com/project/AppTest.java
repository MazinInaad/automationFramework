package com.project;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MInaad on 17/4/2018.
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/com/project/features/",
        glue = {"com/project/steps/", "com/capgemini/ourWebdriver/"},
//        tags = {"@selectie"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
)

public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    @BeforeClass
    public static void setup(){
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmm");
        String now = dateFormatter.format(new Date());
        extentProperties.setReportPath("reports/"+now+"_TestResults.html");
    }

    @AfterClass
    public static void teardown(){
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setSystemInfo("Browser", BrowserFactory.getBrowserType());
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
