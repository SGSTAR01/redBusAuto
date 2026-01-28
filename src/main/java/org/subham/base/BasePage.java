package org.subham.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        BasePage.driver.set(driver);
    }
    public static WebDriver getDriver() {
        return BasePage.driver.get();
    }
    public static void closeDriver() {
        BasePage.driver.remove();
    }
}
