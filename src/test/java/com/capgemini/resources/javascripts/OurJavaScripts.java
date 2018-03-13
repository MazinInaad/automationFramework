package com.capgemini.resources.javascripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by MInaad on 26/2/2018.
 */
public class OurJavaScripts {

    public static String getDisableAnimationScript(){
        String js = "AdfPage.PAGE.setAnimationEnabled(false);";
        return js;
    }

    public static String getMouseOverScript(){
        String js =
                "if(document.createEvent) {" +
                    "var evObj = document.createEvent('MouseEvents');"+
                    "evObj.initEvent('mouseover',true, false);"+
                    "arguments[0].dispatchEvent(evObj);" +
                "}"+
                "else if(document.createEventObject) { "+
                    "arguments[0].fireEvent('onmouseover');"+
                "}";
        return js;
    }
}
