package automation_test.php_travel;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgWebDriver {
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://phptravels.com/demo/");
    }
    @Test
    public void verifyHomePageTitle() {
       String expectedTile = "Demo Script Test drive - PHPTRAVELS";
        String actualTile = ActOn.browser(driver).captureTitles();
        Assert.assertEquals(actualTile, expectedTile);
    }
    @AfterMethod
    public void closeBrowser() {
    ActOn.browser(driver).close();
   }
}
