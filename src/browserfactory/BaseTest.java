package browserfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //Launch the Url
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //Implicit Time Out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void closeBrowser() {
        driver.quit();
    }

    /*
     *This method will get Text from element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    /*
     *This method will Send Text to element
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    /*
     *This method will get Text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }






}
