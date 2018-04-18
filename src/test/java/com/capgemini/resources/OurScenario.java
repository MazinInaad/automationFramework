package com.capgemini.resources;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by MINAAD on 23-11-2017.
 */
public class OurScenario {
    private static Scenario scenario;
    private static String scenarioPath;
    private static int screenShotNumber;
    private static String device;
    public static Date now;
    private static DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmm");

    public static void setScenario(Scenario scenarioSet){
        now = new Date();
        scenario = scenarioSet;
        String browserType = BrowserFactory.getBrowserType();
        scenarioPath = (scenario.getName() + "\\" + browserType + "_" + dateFormatter.format(now));
        screenShotNumber = 1;
        OurAssertions.resetAssertions();
    }

    public static String getScenarioName(){
        return scenario.getName();
    }


    /**
     * Takes a screenshot of the webpage and saves it in a folder
     * "screenshots/scenario name/webbrowser type" in the project directory.
     * <p>
     * The screenshot is always saved as a .png file.
     *
     * @param filename the name to be given to the screenshot without file extension. The name will automatically be prepended with the number of the screenshot taken
     */
    public static void takeScreenShot(String filename) {
        filename += ".png";
        try {
            File scrFile = ((TakesScreenshot) BrowserFactory.getWebDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotFullNameAndPath = System.getProperty("user.dir") +"\\screenshots\\" + scenarioPath +"\\" + String.format("%02d", screenShotNumber++) + "_" + filename;
            FileUtils.copyFile(scrFile, new File(screenshotFullNameAndPath));
            Reporter.addScreenCaptureFromPath(screenshotFullNameAndPath, filename);
        } catch (IOException e) {
            System.out.println("Error occured while trying to save screenshot.");
            e.printStackTrace();
        }
    }

    public static String getDevice() {
        return device;
    }

    public static void setDevice(String setDevice) {
        device = setDevice;
    }

}
