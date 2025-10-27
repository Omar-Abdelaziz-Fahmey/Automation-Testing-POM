package tests.webportal.login;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JasonReader;

public class LoginTest {
    //Variables
    WebDriver driver;
    JasonReader loginData;

    //Tests
    @Description("verify that the user is redirected to home page after providing correct credentials")
    @Tag("validLogin")
    @Owner("Omar")
    @Severity(SeverityLevel.CRITICAL)
    @Link("www.google.com")

    @Test
    public void validLoginTest() {
        Allure.getLifecycle().updateTestCase( testResult ->
                testResult.setName("Valid Login"));
        new LoginPage(driver)
                .LoginPage(loginData.getJsonData("username"), loginData.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }
// behavioral-bases hire
    @Epic("Web Portal")
    @Feature("Login Feature")
    @Story("In Valid Test Cases")
    @Test
    public void invalidLoginTest() {
        Allure.getLifecycle().updateTestCase( testResult ->
                testResult.setName("Invalid Login"));
        new LoginPage(driver)
                .LoginPage(loginData.getJsonData("username"), loginData.getJsonData("invalid-password"))
                .isLoggedIn("https://www.saucedemo.com/v1/");
    }

//    @Test
//    public void invalidLoginTest() {
//        pages.LoginPage loginPage = new pages.LoginPage(driver);
//        loginPage.pages.LoginPage("yassuo", "secret_sauce");
//        Assert.assertFalse(loginPage.isLoggedIn("https://www.saucedemo.com/v1/inventory.html"));
//    }


    //Configurations
    @BeforeMethod
    public void setup() {
        loginData = new JasonReader("login-data");
        driver = WebDriverFactory.initDriver("edge");
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
