package org.subham.base;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static void getDriver() {
        if (BasePage.getDriver() == null) {
            logger.info("Initializing ChromeDriver...");
            ChromeOptions options = getChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            WebDriver driver = new ChromeDriver(options);
            BasePage.setDriver(driver);
            logger.info("ChromeDriver initialized and set in ThreadLocal.");
        }
    }

    private static @NonNull ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--disable-blink-features=AutomationControlled");
        return options;
    }

    public static void quitDriver() {
        if (BasePage.getDriver() != null) {
            logger.info("Quitting ChromeDriver...");
            BasePage.getDriver().quit();
            BasePage.closeDriver();
            logger.info("ChromeDriver quit and removed from ThreadLocal.");
        }
    }
}

