package com.directv.selfcareapp;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "junit:target/seflcareapp-reports/seflcareapp-report.xml",
        "json:target/seflcareapp-reports/seflcareapp-report.json"},
        features = {"src/test/resources/features/login.feature"}
)
public class LoginRunner {

    @Managed
    WebDriver driver;
}
