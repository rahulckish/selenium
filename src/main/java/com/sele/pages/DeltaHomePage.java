package com.sele.pages;

import com.sele.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeltaHomePage {

    WebDriver driver;

    // 🔹 Constructor
    public DeltaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🔹 Locators

    @FindBy(xpath = "(//label[contains(@class,'from-and-to__button-label')])[1]")
    private WebElement fromField;

    @FindBy(xpath = "(//label[contains(@class,'from-and-to__button-label')])[2]")
    private WebElement toField;

    @FindBy(xpath = "//label[contains(text(),'Origin')]")
    private WebElement originLabel;

    @FindBy(xpath = "//label[contains(text(),'Destination')]")
    private WebElement destinationLabel;

    @FindBy(xpath = "(//span[contains(@class,'predictive-search__list__item__content predictive')])[1]")
    private WebElement firstSuggestion;

    @FindBy(xpath = "(//span[contains(text(),'Round Trip')])[1]")
    private WebElement tripType;

    @FindBy(xpath = "//button[contains(text(),'Find Flights')]")
    private WebElement searchFlight;

    // 🔹 Actions

    public void enterFromLocation(String from) {
        try {
            WaitUtils.waitForElement(driver, fromField).click();
            Thread.sleep(1000);

            WebElement fromInput = WaitUtils.waitForElement(driver, By.id(
                    WaitUtils.waitForElement(driver, originLabel).getAttribute("for")));
            fromInput.sendKeys(from);
            Thread.sleep(1500);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    WaitUtils.waitForElement(driver, firstSuggestion));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void enterToLocation(String to) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    WaitUtils.waitForElement(driver, toField));
            Thread.sleep(1000);

            WebElement toInput = WaitUtils.waitForElement(driver, By.id(
                    WaitUtils.waitForElement(driver, destinationLabel).getAttribute("for")));
            toInput.sendKeys(to);
            Thread.sleep(1500);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    WaitUtils.waitForElement(driver, firstSuggestion));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getTripTypeText() {
        return tripType.getText();
    }

    public void clickSearch() {
        try {
            Thread.sleep(1500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    WaitUtils.waitForElement(driver, searchFlight));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 🔹 Validation

    public boolean isFromFieldDisplayed() {
        return fromField.isDisplayed();
    }
}
