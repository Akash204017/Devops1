package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        // Launch Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000); // Optional: wait for UI to settle

        // Navigate to the web page
        driver.get("https://akash204017.github.io/Devops1/");
    }

    @Test
    public void titleValidationTest() {
        // Fetch the actual title
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        // Define expected title
        String expectedTitle = "Image Display Page";

        // Assertions
        Assert.assertNotNull(actualTitle, "Page title is null!");
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        Assert.assertTrue(actualTitle.contains("Page"), "Title should contain 'Page'");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000); // Optional: give a moment before closing
        driver.quit(); // Close the browser
    }
}
