package com.sele.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleTest {

    @Test
    public void verifyGoogleTitle() {

        // Setup ChromeDriver automatically
        //WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            System.out.println("Launching browser...");

            // Open Google
            driver.get("https://www.google.com");

            // Maximize window
            driver.manage().window().maximize();

            // Wait for page load (basic wait)
            Thread.sleep(2000);

            // Get title
            String actualTitle = driver.getTitle();
            System.out.println("Page Title: " + actualTitle);

            // Validate title (better approach)
            Assert.assertTrue(actualTitle.contains("Google"), "Title validation failed!");

            // Validate URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            Assert.assertTrue(currentUrl.contains("google"), "URL validation failed!");

            System.out.println("Test executed successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}