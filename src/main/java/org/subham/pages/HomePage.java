package org.subham.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.subham.base.BasePage;

public class HomePage {


    private final WebDriver driver;
    public HomePage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openSite(String url) {
        driver.get(url);
    }

}
