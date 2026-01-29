package org.subham.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.subham.base.BasePage;

import java.time.Duration;

public class WaitUtils {
    public static void waitForVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static WebElement waitForNestedElement(WebElement element, By locator) {
        WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }
}
