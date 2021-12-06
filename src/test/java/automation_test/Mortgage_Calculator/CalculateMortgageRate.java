package automation_test.Mortgage_Calculator;

import Utilities.DateUtils;
import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigatorBar;

public class CalculateMortgageRate {
    WebDriver driver;

    @BeforeMethod
    public void webBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @Test
    public void calculateMonthlyPayment() {
        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];


         new NavigatorBar(driver)
                .navigateToHome()
                .TypeHomePrice("30000")
                .TypeDownPayment("60000")
                .CClickDownPaymentInDollar()
                .TypeLoanAmount("240000")
                .TypeInterestRate("3%")
                .TypeLoanTermYears("30")
                .SelectMonth(month).
                TypeYear(year)
                .TypePropertyTax("5000")
                .TpePmi("0.5")
                .TpeHoi("1000")
                .TypeHoa("100")
                .SelectLoanType("FHA")
                .SelectBuyOrRefiOption("Buy")
                .ClickCalculateButton()
                .ValidateTotalMonthlyPayment("$1,611.85");
    }

    @AfterMethod
    public void quitBrowser() {
        ActOn.browser(driver).close();
    }

 }