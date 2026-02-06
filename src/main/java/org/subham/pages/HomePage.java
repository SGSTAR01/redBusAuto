package org.subham.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.subham.base.BasePage;
import org.subham.locators.HomePageLocators;
import org.subham.utils.WaitUtils;

import java.util.List;

public class HomePage {

    private final WebDriver driver;

    public HomePage() {
        driver = BasePage.getDriver();
    }


    public void openSite(String url) {
        driver.get(url);
    }

    public boolean isHomePageLoaded() {
            WebElement element = WaitUtils.waitForVisible(HomePageLocators.FROM_CITY_INPUT);
            return element.isDisplayed();

    }

    public void enterFromCityInput(String fromCity)  {
        WebElement element = WaitUtils.waitForVisible(HomePageLocators.FROM_CITY_INPUT);
        element.clear();
        element.sendKeys(fromCity);
    }

    public void enterToCityInput(String toCity) {
        WebElement element = WaitUtils.waitForClickable(HomePageLocators.TO_CITY_INPUT);
        element.click();
        element.clear();
        element.sendKeys(toCity);
    }

    public void selectBoardingPoint(String boardingPoint)  {
        String dynamicXpath = String.format(
                "//div[contains(text(),'%s')]", boardingPoint
        );
        WebElement boardingContainer = WaitUtils.waitForVisible(HomePageLocators.BOARDING_CONTAINER);
        WebElement boarding = WaitUtils.waitForNestedElement(boardingContainer,By.xpath(dynamicXpath));
        boarding.click();
    }

    public void selectDate(String date) throws InterruptedException {
        String[] parts = date.split(" ");
        String day = parts[0];
        String monthAndYear = parts[1] + " " + parts[2];

        WebElement dateSelector = WaitUtils.waitForClickable(HomePageLocators.DATE_SELECTOR);
        dateSelector.click();
        while (true) {
            WebElement monthYearSelector = WaitUtils.waitForVisible(HomePageLocators.MONTH_YEAR_SELECTOR);
            String currentText = monthYearSelector.getText();
            if (currentText.contains(monthAndYear)) {
                break;
            }
            WebElement nextButton = driver.findElement(HomePageLocators.NEXT_BUTTON);
            nextButton.click();
        }
        WebElement allDays = WaitUtils.waitForClickable(HomePageLocators.ALL_DAYS);
        String dynamicDatePath = String.format(
                "//div[contains(@class,'calendarDate')]//span[text()='%s']", day
        );
        try {
            WebElement boardingDate = WaitUtils.waitForNestedElement(allDays,By.xpath(dynamicDatePath));
            boardingDate.click();
        } catch (Exception e) {
            throw new RuntimeException("Date not found or invalid" + e.getMessage());
        }
    }

    public void searchBuses() {
        WebElement element = WaitUtils.waitForClickable(HomePageLocators.SEARCH_BUTTON);
        element.click();
    }

}
