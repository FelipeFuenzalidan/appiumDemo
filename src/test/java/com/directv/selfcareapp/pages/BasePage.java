package com.directv.selfcareapp.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigurationReader;

public class BasePage extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static boolean isIOS;

    private static boolean isAndroid;

    public static void setAndroid(boolean android){

        isAndroid = android;
    }

    public static boolean isAndroid(){
        return isAndroid;
    }

    public static void setIOS(boolean ios){
        isIOS = ios;
    }

    public static boolean isIOS(){
        return isIOS;
    }

    public WebElement waitForElement(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public int timeout(){
        return Integer.parseInt(ConfigurationReader.getProperty("serenity.timeout"));
    }

    public boolean isDisplayed(WebElement element) {
        return waitForElement(element, timeout()).isDisplayed();
    }

    public String getText(WebElement element){
        return waitForElement(element, timeout()).getText();
    }

    public void type(WebElement element, String text) {
        if(isDisplayed(element)){
            waitForElement(element, timeout()).sendKeys(text);
        }
    }

    public void tap(WebElement element) {
        if(isDisplayed(element)) {
            waitForElement(element, timeout()).click();
        }
    }

    public void switchApp(){
        getDriver().quit();
    }
}
