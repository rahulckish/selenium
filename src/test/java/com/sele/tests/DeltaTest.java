package com.sele.tests;

import com.sele.base.BaseTest;
import com.sele.pages.DeltaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeltaTest extends BaseTest {

    @Test
    public void verifyFlightSearchFields() {

        driver.get("https://www.delta.com");

        DeltaHomePage page = new DeltaHomePage(driver);

        // Validate page loaded
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("delta"));

        // Validate field
        Assert.assertTrue(page.isFromFieldDisplayed());

        // Perform actions
        page.enterFromLocation("COK");
        page.enterToLocation("BLR");

        // Validate trip type
        Assert.assertTrue(page.getTripTypeText().contains("Round"));
        page.clickSearch();
    }
}