package com.training.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        ChromeOptions options = new ChromeOptions();

        // Run headless if you pass: -Dheadless=true
        if ("true".equalsIgnoreCase(System.getProperty("headless", "false"))) {
            options.addArguments("--headless");
        }

        options.addArguments("--start-maximized");

        // Selenium Manager (inside Selenium 4+) will auto-manage driver in most machines
        driver.set(new ChromeDriver(options));
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}