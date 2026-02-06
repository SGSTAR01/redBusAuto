package org.subham.locators;

import org.openqa.selenium.By;

public class ResultPageLocators {
    public static final By RESULT_LIST = By.xpath("//*[@id='searchContentWrap']//ul/li");
    public static final By SEAT_LAYOUT = By.xpath("//*[@id='seat-canvas-wrapper']/div[2]/div");
    public static final By SEATS = By.xpath("//*[@id='seat-canvas-wrapper']//span[contains(@aria-label,'Seat number')]");
}

