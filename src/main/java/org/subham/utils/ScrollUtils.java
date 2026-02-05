package org.subham.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.subham.base.BasePage;

public class ScrollUtils {
        public static void scrollToElement(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) BasePage.getDriver();
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        }
}
