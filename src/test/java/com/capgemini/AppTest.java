package com.capgemini;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", jsonUsageReport = "target/cucumber-usage.json", outputFolder = "target/", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = false, reportPrefix = "DNA_results_")
@CucumberOptions(
        plugin = {"pretty:target/cucumber-pretty.txt", "json:target/cucumber.json", "usage:target/cucumber-usage.json"},
        features = "src/test/java/com/project/features/",
        glue = {"com/project/steps/", "com/capgemini/ourWebdriver/"}
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
}
