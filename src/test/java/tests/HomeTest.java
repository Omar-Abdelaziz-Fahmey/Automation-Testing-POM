package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeTest {

    //Variables
    WebDriver driver;

    //Tests
    @Test
    public void addToCartTest() {
        new LoginPage(driver)
                .LoginPage("standard_user", "secret_sauce")
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html")
                .addToCart()
                .validateCartIcon();
    }

    //Configurations
    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
