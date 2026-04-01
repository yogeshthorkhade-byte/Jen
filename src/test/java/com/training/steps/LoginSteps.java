package com.training.steps;

import com.training.factory.DriverFactory;
import com.training.reports.ExtentLogger;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I open the Internet App login page")
    public void i_open_login_page() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ExtentLogger.step("Open URL: https://the-internet.herokuapp.com/login");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I login with username {string} and password {string}")
    public void i_login(String username, String password) {
        ExtentLogger.step("Enter username: " + username);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        ExtentLogger.step("Enter password: " + password);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        ExtentLogger.step("Click Login button");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("I should see message containing {string}")
    public void verify_message(String expectedText) {
        ExtentLogger.step("Verify flash message contains: " + expectedText);

        String actual = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash"))
        ).getText();

        // #flash has extra "×" close symbol, so we check "contains"
        Assert.assertTrue(actual.contains(expectedText),
                "Expected to contain: [" + expectedText + "] but actual was: [" + actual + "]");
    }
}