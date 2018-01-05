package com.capgemini.resources;

import com.capgemini.ourWebdriver.BrowserFactory;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by MINAAD on 23-11-2017.
 */
public class OurScenario {
    private static Scenario scenario;
    private static String scenarioPath;
    private static int screenShotNumber;
    private static String device;

    public OurScenario() {
    }

    public static void setScenario(Scenario scenarioSet){
        scenario = scenarioSet;
    }

    public static Scenario getScenario(){
        return scenario;
    }

    public static void setScenarioPath(String scenarioPathSet) {
        scenarioPath = scenarioPathSet;
        screenShotNumber = 1;
    }

    /**
     * Takes a screenshot of the webpage and saves it in a folder
     * "screenshots/scenario name/webbrowser type" in the project directory.
     * <p>
     * The screenshot is always saved as a .png file.
     *
     * @param filename the name to be given to the screenshot without file extension. The name will automatically be prepended with the number of the screenshot taken
     * @throws IOException
     */
    public static void takeScreenShot(String filename) throws IOException {
        filename += ".png";

        File scrFile = ((TakesScreenshot) BrowserFactory.getWebDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"\\screenshots\\" + scenarioPath +"\\" + String.format("%02d", screenShotNumber++) + "_" + filename));
    }

    public static String getDevice() {
        return device;
    }

    public static void setDevice(String setDevice) {
        device = setDevice;
    }

}
