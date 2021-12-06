package automation_test.mortgage_calculator_parameterized;
import Utilities.DateUtils;
import Utilities.ReadConfigFiles;
import Utilities.SqlConnector;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRateParameterized {
    private static final Logger LOGGER= LogManager.getLogger(CalculateMortgageRateParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("..................Test Name: Calculate Monthly payment.............");

        String browserUrl = ReadConfigFiles.getPropertyValues("url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

        @Test
        public void calculateMonthlyPayment () {
            String date = DateUtils.returnNextMonth();
            String[] dates = date.split("-");
            String month = dates[0];
            String year = dates[1];

            try {
                ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
                while (rs.next()) {
                        new NavigatorBar(driver)
                                .navigateToHome()
                                .TypeHomePrice(rs.getString("homevalue"))
                                .TypeDownPayment(rs.getString("downpayment"))
                                .CClickDownPaymentInDollar()
                                .TypeLoanAmount(rs.getString("loanamount"))
                                .TypeInterestRate(rs.getString("interestrate"))
                                .TypeLoanTermYears(rs.getString("loanterm"))
                                .SelectMonth(month).
                                TypeYear(year)
                                .TypePropertyTax(rs.getString("propertytax"))
                                .TpePmi(rs.getString("pmi"))
                                .TpeHoi(rs.getString("Hoi"))
                                .TypeHoa(rs.getString("hoa"))
                                .SelectLoanType(rs.getString("loantype"))
                                .SelectBuyOrRefiOption(rs.getString("buyorrefi"))
                                .ClickCalculateButton()
                                .ValidateTotalMonthlyPayment(rs.getString("totalmpnthlypaayment"));
                    }
                } catch (SQLException e) {
               LOGGER.error(e.getMessage());
            }
        }
        @AfterMethod
            public void quitBrowser () {
                LOGGER.info("...End test case....");
                ActOn.browser(driver).close();
            }
        }

