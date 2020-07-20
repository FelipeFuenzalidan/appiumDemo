package com.directv.selfcareapp.stepdefinitions;

import com.browserstack.local.Local;
import com.directv.selfcareapp.pages.BasePage;
import com.directv.selfcareapp.steps.LoginSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import java.util.HashMap;
import java.util.Map;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDefinitions {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    static Local bsLocal;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void setPlatform() throws Exception {
        String platform =  System.getProperty("testPlatform");
        Local bsLocal = new Local();
        System.out.println(bsLocal);
        HashMap<String, String> bsLocalArgs = new HashMap<>();
        bsLocalArgs.put("key", "AqQuGGRnEF3LFrRpvxYQ");
        bsLocal.start(bsLocalArgs);
        System.out.println(bsLocal.isRunning());
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

    @When("^I type \"([^\"]*)\" in the field username$")
    public void iTypeInTheFieldUsername(String username) {
        loginSteps.typeUsername(username);

    }

    @After
    public static void tearDown() throws Exception {
        if (bsLocal != null) {
            bsLocal.stop();
        }
    }
}
