package org.subham.locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By FROM_CITY_INPUT = By.id("srcinput");
    public static final By TO_CITY_INPUT = By.id("destinput");
    public static final By BOARDING_CONTAINER = By.xpath("//div[@role='listbox']");
    public static final By DATE_SELECTOR = By.xpath("//div[contains(@aria-label,'Select Date of Journey.')]");
    public static final By MONTH_YEAR_SELECTOR = By.xpath("//div[contains(@class,'monthArea')]");
    public static final By NEXT_BUTTON = By.xpath("//i[contains(@aria-label,'Next month')]");
    public static final By ALL_DAYS = By.xpath("//ul[contains(@class,'datesWrap')]");
    public static final By SEARCH_BUTTON = By.xpath("//button[@aria-label='Search buses']");
}

