package com.directv.selfcareapp;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "junit:target/cucumber-reports/Cucumber.xml"},
        features = {"src/test/resources/features/login.feature"}
)
public class LoginRunner {

    @Managed
    WebDriver driver;
}
