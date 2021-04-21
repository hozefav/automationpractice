package com.mytesting.automation.driver;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    Capabilities getCapabilities();

    WebDriver getDriver();
}