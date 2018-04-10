package com.capgemini.runners;



import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
//
//@CucumberOptions(
//        features = "src/test/java/com/project/features/",
//        glue = {"com/project/steps/", "com/capgemini/ourWebdriver/"},
//        plugin = {"pretty"}
//)

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", jsonUsageReport = "target/cucumber-usage.json", outputFolder = "reports/", detailedReport = true, detailedAggregatedReport = false, overviewReport = true, toPDF = false, reportPrefix = "DNA_results_")
@CucumberOptions(
        plugin = {"pretty:target/cucumber-pretty.txt", "json:target/cucumber.json", "usage:target/cucumber-usage.json"},
        features = "src/test/java/com/project/features/",
        glue = {"com/project/steps/", "com/capgemini/ourWebdriver/"}
)

public class AllFeaturesTest {

    @BeforeClass
    public static void setUp(){
        System.out.println("This is the BeforeClass Execution.");
    }

    @Test
    public void dummy(){}

    @AfterClass
    public static void tearDown(){
        System.out.println("This is the afterClass exection.");
    }
}
