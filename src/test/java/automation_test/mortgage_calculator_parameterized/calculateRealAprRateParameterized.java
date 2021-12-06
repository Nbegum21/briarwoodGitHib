package automation_test.mortgage_calculator_parameterized;

import Utilities.ReadConfigFiles;
import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigatorBar;
import paramteres.DataProviderClass;

public class calculateRealAprRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(calculateRealAprRateParameterized.class);
    WebDriver driver;

        @BeforeMethod
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            LOGGER.info(".................test Name: Calculate Real Apr........");


            String browserUrl = ReadConfigFiles.getPropertyValues("url");
            ActOn.browser(driver).openBrowser(browserUrl);

        }

        @Test(dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
        public void CalculateRealApr(String HomePrice,String downPayment, String interestRate, String actualApr) {
            new NavigatorBar(driver)
                    .mouseHoverToRates()
                    .navigateToRealApr()
                    .WaitForPgeToLoad()
                    .TypeHomePrice(HomePrice)
                    .TypeDownPayment(downPayment)
                    .ClickDownPaymentInDollar()
                    .TypeInterestRate(interestRate)
                    .ClickCalculateButton()
                    .ValidatingRealAprRate(actualApr);
        }

        @AfterMethod
        public void closeBrowser() {
            LOGGER.info("......End Test Case: Calculate Real Apr....");
            ActOn.browser(driver).close();
        }
    }


