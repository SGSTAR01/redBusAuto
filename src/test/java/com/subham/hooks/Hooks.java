package com.subham.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.subham.base.BasePage;
import org.subham.base.DriverFactory;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        WebDriver driver = BasePage.getDriver();
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }

    @After(order = 0)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
