package org.subham.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.subham.base.BasePage;
import org.subham.utils.ScrollUtils;
import org.subham.utils.WaitUtils;

import java.util.List;


public class ResultPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"searchContentWrap\"]//ul/li")
    private List<WebElement> resultList;

    @FindBy(xpath = "//*[@id=\"seat-canvas-wrapper\"]/div[2]/div")
    private WebElement seatLayout;

    @FindBy(xpath = "//*[@id=\"seat-canvas-wrapper\"]/div[2]/div/span")
    private List<WebElement> seats;

    public ResultPage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isResultsDisplayed() {
        WaitUtils.waitForAllElements(resultList);
        return !resultList.isEmpty();
    }

    public void selectBus(int index) {
        if(index >= 0 && index < resultList.size()) {
           WebElement result = resultList.get(index);
            ScrollUtils.scrollToElement(result);
            result.click();
        }
    }

    public boolean isSeatLayoutDisplayed() {
        WaitUtils.waitForVisible(seatLayout);
        return seatLayout.isDisplayed();
    }

    public void selectSeat(int index) {
        WaitUtils.waitForVisible(seats.get(index));
        if(index < seats.size()) {
            WebElement seat = seats.get(index);
            String seatAvailability = seat.getAttribute("aria-label");
            if(seatAvailability != null && seatAvailability.contains("available")) {
                ScrollUtils.scrollToElement(seat);
                seat.click();
            }
            else {
                System.out.println("Seat is not available for booking.");
            }
        }
    }

    public boolean isSeatSelected(int index) {
        if(index < seats.size()) {
            WebElement seat = seats.get(index);
            return Boolean.parseBoolean(seat.getAttribute("aria-pressed"));
        }
        return false;
    }
}
