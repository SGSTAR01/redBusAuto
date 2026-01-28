package com.subham.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.subham.base.DriverFactory;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
