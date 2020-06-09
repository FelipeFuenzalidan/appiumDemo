package com.directv.selfcareapp.stepdefinitions;

import com.directv.selfcareapp.pages.BasePage;
import com.directv.selfcareapp.steps.LoginSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDefinitions {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setPlatform() {
        String platform =  System.getProperty("testPlatform");
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePage.setAndroid(true);
            BasePage.setIOS(false);
        }
        else {
            BasePage.setAndroid(false);
            BasePage.setIOS(true);
        }
    }

    @Given("I login the (.*) and (.*)")
    public void ILoginTheUsernameAndPasswordFortheUserType(String username, String password){
        loginSteps.LoginUser(username, password);
    }

    @Then("I verify that the user login successful")
    public void IVerifyThatTheUserLoginSuccessful(){
        loginSteps.verifyLoginSuccessful();
    }

    @When("I press the Ayuda menu")
    public void IPressTheAyudaMenu(){
        loginSteps.enterAyudaMenu();
    }

    @And("I press the Whatsapp button")
    public void IPressTheEnviarMensajeButton(){
        loginSteps.enterWhatsApp();
    }

    @Then("I verify that it is on WhatsApp")
    public void IVerifyThatItIsOnWhatsApp() throws InterruptedException {
        loginSteps.verifySuccessfulWhatsApp();
    }

    @Then("I verify that the username is {string}")
    public void IVerifyThatTheUsername(String username){
        loginSteps.verifyUsername(username);
    }

    @And("I logout in the Directv app")
    public void ILogoutInTheSpp(){
        loginSteps.logout();
    }

    @And("I switch to the Directv app")
    public void ISwitchToTheDirectvApp(){
        loginSteps.swithAppDirectv();
    }

    @When("I type {string} in the field username")
    public void iTypeInTheFieldUsername(String username) {
        loginSteps.typeUsername(username);
    }
}
