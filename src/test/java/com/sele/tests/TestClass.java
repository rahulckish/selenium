package com.sele.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Sample test class.
 * Note: Class is named "Test" so we use the fully qualified annotation
 * to avoid conflict with org.testng.annotations.Test.
 */

public class TestClass {
    @Test
    public void sampleTest() {
        System.out.println("Hello World");
        Assert.assertTrue(true);
    }
}
