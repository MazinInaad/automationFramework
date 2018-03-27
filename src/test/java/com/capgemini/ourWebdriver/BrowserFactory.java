package com.capgemini.ourWebdriver;

import com.capgemini.resources.OurScenario;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 * Created by DLAMMERS on 24/1/2017.
 * Updated by MInaad on 18/12/2017
 */
public class BrowserFactory {

    static OurWebDriver browser;


    public static OurFirefoxDriver createFfDriver(){
        return OurFirefoxDriver.getBrowser();
    }

    public static OurChromeDriver createChromeDriver(){
        return OurChromeDriver.getBrowser();
    }

    public static OurIEDriver createIEDriver(){
        return OurIEDriver.getBrowser();
    }

    public static OurWebDriver getWebDriver() {
        String browserType = getBrowserType();
        return getBrowserOfType(browserType);
    }

    private static OurWebDriver getBrowserOfType(String browserType) {
        if(browserType==null){
            browser = OurFirefoxDriver.getBrowser();
        }
        else if (browserType.equals("chrome")) {
            OurScenario.setDevice("Desktop");
            browser = OurChromeDriver.getBrowser();
        } else if (browserType.equals("ie")) {
            OurScenario.setDevice("Desktop");
            browser = OurIEDriver.getBrowser();

        } else if (browserType.equals("firefox")) {
            OurScenario.setDevice("Desktop");
            browser = OurFirefoxDriver.getBrowser();
        }
        else {
            OurScenario.setDevice("Mobile");
            browser = OurChromeDriver.getBrowser();
        }
        return browser;
    }

    public static String getBrowserType() {
        return getBrowserProperty("browser.type");
    }

    public static String getEnvironment(){
        return getBrowserProperty("environment");
    }

    private static String getBrowserProperty(String propertyToGet) {
        Properties prop = new Properties();
        InputStream input;
        String propertyValue = null;

        try {

            input = new FileInputStream(System.getProperty("user.dir") +"\\browser.properties");
            prop.load(input);
            propertyValue = prop.getProperty(propertyToGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }



}
