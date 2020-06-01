package com.directv.selfcareapp.steps;

import com.directv.selfcareapp.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class LoginSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginPage loginPage;

    @Step
    public void LoginUser(String username, String password){
        LOGGER.info("Type username");
        loginPage.typeUsernameField(username);
        LOGGER.info("Type password");
        loginPage.typePasswordField(password);
        LOGGER.info("Tap in Ingresar button");
        loginPage.tapIngresarButton();
    }

    @Step
    public void verifyLoginSuccessful(){
        LOGGER.info("I verify that the user login successful");
        loginPage.isDisplayedPagarFacturaButton();
    }

    @Step
    public void enterAyudaMenu(){
        LOGGER.info("I press the Ayuda menu");
        loginPage.tapAyudaButon();
    }

    @Step
    public void enterWhatsApp(){
        LOGGER.info("I press the ENVIAR MENSAJE button");
        loginPage.tapEnviarMensajeButton();
    }

    @Step
    public void verifySuccessfulWhatsApp() throws InterruptedException {
        LOGGER.info("I verify that it is on WhatsApp");
        LOGGER.info("The url is: " + loginPage.getWhatsAppUrl());
        assertTrue(loginPage.getWhatsAppUrl().contains("whatsapp"));
    }

    @Step
    public void verifyLogout() {
        LOGGER.info("I verify that the logout successful");
        loginPage.logout();
    }

    @Step
    public void typeUsername(String username){
        LOGGER.info("type username");
        loginPage.typeUsernameField(username);
    }

    @Step
    public void verifyUsername(String username){
        LOGGER.info("I verify the value username");
        assertEquals("The" + username + "username does not exits.", loginPage.getValueUsername(), username);
    }

    @Step
    public void logout(){
        LOGGER.info("I logout in the app");
        loginPage.logout();
    }

    @Step
    public void swithAppDirectv(){
        LOGGER.info("I switch to the Directv app");
        loginPage.switchApp();
    }
}
