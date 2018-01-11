package com.capgemini.resources.config;

import com.capgemini.ourWebdriver.BrowserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by MINAAD on 11-1-2018.
 */
public class ConfigReader {
    /**
     * Depending on the environment set in the {@Link browser.properties} file, the value of the requested property parameter
     * is returned. The properties files should be located in src/test/java/com/project/resources/config
     * @param propertyToGet
     * @return String value of the property requested
     */
    public static String getProperty(String propertyToGet) {
        Properties prop = new Properties();
        InputStream input;
        String propertyValue = null;

        try {
            input = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\com\\project\\resources\\config\\" + BrowserFactory.getEnvironment() +".properties");
            prop.load(input);
            propertyValue = prop.getProperty(propertyToGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}
