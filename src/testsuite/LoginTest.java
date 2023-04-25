package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //method of userShouldLoginSuccessfullyWithValidCredentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Requirements

        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));

        String expectedText = "Products";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        // Verifying actual text matching with expected text
        Assert.assertEquals("PRODUCTS text not displayed", expectedText, actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Username and Password
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));

        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int totalProducts = productNo.size();
        // This is from requirement
        int expectedNumber = 6;
        // Verifying actual number matching with expected number
        Assert.assertEquals("Products numbers not matching", expectedNumber, totalProducts);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
