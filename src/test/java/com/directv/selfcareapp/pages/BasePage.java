package com.directv.selfcareapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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

    public static void setIOS(boolean iOS){
        isIOS = iOS;
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

    public void swipeUp(){
        LOGGER.info("Dentro del swipeup");
        LOGGER.info("Calculando coordenadas");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver facade = getDriver();
        AppiumDriver driver = (AppiumDriver) ((WebDriverFacade)facade).getProxiedDriver();
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int y = ((size.height) - (3 * (size.height / 4)));
        int y1 = ((size.height) - (size.height / 4));

        LOGGER.info("Generando accion");
        TouchAction action = new TouchAction(driver);
        action.press(x, y1)
                .waitAction(500)
                .moveTo(x, y)
                .release()
                .perform();
    }

    public void swipeDown(){
        LOGGER.info("Dentro del swipedown");
        LOGGER.info("Calculando coordenadas");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver facade = getDriver();
        AppiumDriver driver = (AppiumDriver) ((WebDriverFacade)facade).getProxiedDriver();
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int y1 = ((size.height) - (3 * (size.height / 4)));
        int y = ((size.height) - (size.height / 4));

        LOGGER.info("Generando accion");
        TouchAction action = new TouchAction(driver);
        action.press(x, y1)
                .waitAction(500)
                .moveTo(x, y)
                .release()
                .perform();
    }
}
