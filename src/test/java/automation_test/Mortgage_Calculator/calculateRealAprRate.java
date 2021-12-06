package automation_test.Mortgage_Calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigatorBar;

public class calculateRealAprRate {
    WebDriver driver;

        @BeforeMethod
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
        }

        @Test
        public void CalculateRealApr() {
            new NavigatorBar(driver)
                    .mouseHoverToRates()
                    .navigateToRealApr()
                    .WaitForPgeToLoad()
                    .TypeHomePrice("200000")
                    .TypeDownPayment("15000")
                    .ClickDownPaymentInDollar()
                    .TypeInterestRate("3")
                    .ClickCalculateButton()
                    .ValidatingRealAprRate("3.130%");
        }

        @AfterMethod
        public void closeBrowser() {ActOn.browser(driver).close();}
    }


