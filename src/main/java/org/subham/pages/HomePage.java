package org.subham.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.subham.base.BasePage;
import org.subham.utils.WaitUtils;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div[2]/search/div/div/div[1]/div[1]/div[1]/div[1]")
    private WebElement fromCityWrapper;
    @FindBy(id = "srcinput")
    private WebElement fromCityInput;
    @FindBy(id = "destinput")
    private WebElement toCityInput;
    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement boardingContainer;
    //Calender
    @FindBy(xpath = "//div[contains(@aria-label,'Select Date of Journey.')]")
    private WebElement dateSelector;
    @FindBy(xpath = "//div[contains(@class,'monthArea')]")
    private WebElement monthYearSelector;
    @FindBy(xpath = "//i[contains(@aria-label,'Next month')]")
    private WebElement nextButton;
    @FindBy(xpath = "//ul[contains(@class,'datesWrap')]")
    private WebElement allDays;

    @FindBy(xpath = "//button[@aria-label='Search buses']")
    private WebElement searchButton;

    private final WebDriver driver;

    public HomePage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void openSite(String url) {
        driver.get(url);
    }

    public boolean isHomePageLoaded() {

            WaitUtils.waitForVisible(fromCityWrapper);
            return fromCityInput.isDisplayed();

    }

    public void enterFromCityInput(String fromCity)  {
        WaitUtils.waitForClickable(fromCityWrapper);
        fromCityWrapper.click();
        WaitUtils.waitForVisible(fromCityInput);
        fromCityInput.clear();
        fromCityInput.sendKeys(fromCity);
    }

    public void enterToCityInput(String toCity) {
        WaitUtils.waitForClickable(toCityInput);
        toCityInput.click();
        toCityInput.clear();
        toCityInput.sendKeys(toCity);
    }

    public void selectBoardingPoint(String boardingPoint)  {
        String dynamicXpath = String.format(
                "//div[contains(text(),'%s')]", boardingPoint
        );
        WebElement boarding = WaitUtils.waitForNestedElement(boardingContainer,By.xpath(dynamicXpath));
        boarding.click();
    }

    public void selectDate(String date) throws InterruptedException {
        String[] parts = date.split(" ");
        String day = parts[0];
        String monthAndYear = parts[1] + " " + parts[2];

        WaitUtils.waitForClickable(dateSelector);
        dateSelector.click();
        while (true) {
            String currentText = monthYearSelector.getText();
            if (currentText.contains(monthAndYear)) {
                break;
            }
            nextButton.click();
        }
        WaitUtils.waitForClickable(allDays);
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
        WaitUtils.waitForClickable(searchButton);
        searchButton.click();
    }

}
