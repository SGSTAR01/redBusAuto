package org.subham.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.subham.base.BasePage;
import org.subham.locators.ResultPageLocators;
import org.subham.utils.ScrollUtils;
import org.subham.utils.WaitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ResultPage {

    private static final Logger logger = LoggerFactory.getLogger(ResultPage.class);
    private final WebDriver driver;

    public ResultPage() {
        driver = BasePage.getDriver();
    }

    public boolean isResultsDisplayed() {
        List<WebElement> resultList = WaitUtils.waitForAllElements(ResultPageLocators.RESULT_LIST);
        return !resultList.isEmpty();
    }

    public void selectBus(int index) {
        List<WebElement> resultList = WaitUtils.waitForAllElements(ResultPageLocators.RESULT_LIST);
        if(index >= 0 && index < resultList.size()) {
           WebElement result = resultList.get(index);
            ScrollUtils.scrollToElement(result);
            result.click();
        }
    }

    public boolean isSeatLayoutDisplayed() {
        WebElement seatLayout = WaitUtils.waitForVisible(ResultPageLocators.SEAT_LAYOUT);
        return seatLayout.isDisplayed();
    }

    public void printSeatStatus() {
        List<WebElement> seats = WaitUtils.waitForAllElements(ResultPageLocators.SEATS);
        int totalSeats = seats.size();
        int availableSeats = 0;
        int soldSeats = 0;

        if (totalSeats > 0) {
            for (WebElement seat : seats) {
                String seatAvailability = seat.getAttribute("aria-label");
                String seatNumber = seat.getAttribute("id");
                assert seatAvailability != null;
                if (seatAvailability.contains("available")) {
                    logger.info("Seat number:{} is available", seatNumber);
                    availableSeats++;
                }
                if (seatAvailability.contains("sold")) {
                    logger.info("Seat number:{} is sold", seatNumber);
                    soldSeats++;
                }
            }
            logger.info("{} total seats", totalSeats);
            logger.info("{} sold seats", soldSeats);
            logger.info("{} available seats", availableSeats);
        }
        else  {
            logger.info("No seats available");
        }
    }

    public void selectSeat(int index) {
        List<WebElement> seats = WaitUtils.waitForAllElements(ResultPageLocators.SEATS);
        WaitUtils.waitForVisible(seats.get(index));
        if(index < seats.size()) {
            WebElement seat = seats.get(index);
            String seatAvailability = seat.getAttribute("aria-label");
            if(seatAvailability != null && seatAvailability.contains("available")) {
                ScrollUtils.scrollToElement(seat);
                seat.click();
            }
            else {
                logger.info("Seat is not available for booking.");
            }
        }
    }



    public boolean isSeatSelected(int index) {
        List<WebElement> seats = WaitUtils.waitForAllElements(ResultPageLocators.SEATS);
        if(index < seats.size()) {
            WebElement seat = seats.get(index);
            return Boolean.parseBoolean(seat.getAttribute("aria-pressed"));
        }
        return false;
    }
}
