package com.directv.selfcareapp.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"E-mail\")")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"login-username-field\"]")
    private WebElement usernameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Contraseña\")")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"login-password-field\"]")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"INGRESAR\")")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"login-submit-button\"]")
    private WebElement ingresarButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'PAGAR FACTURA')]")
    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"PAGAR FACTURA\"]")
    private WebElement pagarFacturaButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Ayuda')]")
    @iOSFindBy(xpath = "demo")
    private WebElement ayudaButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Whatsapp')]")
    @iOSFindBy(xpath = "demo")
    private WebElement enviarMensajeButton;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    @iOSFindBy(xpath = "demo")
    private WebElement urlWhatsApp;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Perfil\")")
    @iOSFindBy(xpath = "demo")
    private WebElement perfil;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"CERRAR SESIÓN\")")
    @iOSFindBy(xpath = "demo")
    private WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'INICIAR SESIÓN')]")
    @iOSFindBy(xpath = "demo")
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

    public void isDisplayedPagarFacturaButton(){
        isDisplayed(pagarFacturaButton);
    }

    public void tapAyudaButon(){
        tap(ayudaButton);
    }

    public void tapEnviarMensajeButton(){
        tap(enviarMensajeButton);
    }

    public String getWhatsAppUrl() throws InterruptedException {
        Thread.sleep(2000);
        return urlWhatsApp.getText();
    }

    public void logout(){
        tap(perfil);
        tap(logoutButton);
        isDisplayed(iniciarSesionLabel);
    }

    public String getValueUsername(){
        return getText(usernameField);
    }

    public void swicthAppDirectv(){
        switchApp();
    }
}
