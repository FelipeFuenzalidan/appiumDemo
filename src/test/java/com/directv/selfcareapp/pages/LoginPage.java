package com.directv.selfcareapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"E-mail\")")
    @iOSFindBy(xpath = "")
    private WebElement usernameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Contraseña\")")
    @iOSFindBy(xpath = "")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"INGRESAR\")")
    @iOSFindBy(xpath = "")
    private WebElement ingresarButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'incorrectas')]")
    @iOSFindBy(xpath = "")
    private WebElement msgFailedLogin;

    @AndroidFindBy(xpath = "//*[contains(@text, 'PAGAR FACTURA')]")
    @iOSFindBy(xpath = "")
    private WebElement pagarFacturaButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Ayuda')]")
    @iOSFindBy(xpath = "")
    private WebElement ayudaButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'ENVIAR MENSAJE')]")
    @iOSFindBy(xpath = "")
    private WebElement enviarMensajeButton;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    @iOSFindBy(xpath = "")
    private WebElement urlWhatsApp;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mis datos\")")
    @iOSFindBy(xpath = "")
    private WebElement misDatosMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGOUT\")")
    @iOSFindBy(xpath = "")
    private WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'INICIAR SESIÓN')]")
    @iOSFindBy(xpath = "")
    private WebElement iniciarSesionLabel;


    public void typeUsernameField(String username){
        type(usernameField, username);
    }

    public void typePasswordField(String password){
        type(passwordField, password);
    }

    public void tapIngresarButton(){
        tap(ingresarButton);
    }

    public void isDisplayedMsgFailedLogin(){
        isDisplayed(msgFailedLogin);
    }

    public void isDisplayedPagarFacturaButton(){
        isDisplayed(pagarFacturaButton);
    }

    public void tapAyudaButon(){
        tap(ayudaButton);
    }

    public void tapEnviarMensajeButton(){
        swipeUp();
        tap(enviarMensajeButton);
    }

    public String getWhatsAppUrl() throws InterruptedException {
        Thread.sleep(2000);
        return urlWhatsApp.getText();
    }

    public void logout(){
        tap(misDatosMenu);
        tap(logoutButton);
        isDisplayed(iniciarSesionLabel);
    }
}
