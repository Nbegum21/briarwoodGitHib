package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementAssertions {
    WebDriver driver;
    private By locator;

    ElementAssertions(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAssertions elementIsDisplayed() {
        boolean displayed = driver.findElement(locator).isDisplayed();
        Assert.assertTrue(displayed,"the expected element does not exit");
        return this;
    }

}
