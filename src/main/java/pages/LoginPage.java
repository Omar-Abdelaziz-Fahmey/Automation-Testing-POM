package pages;

import bots.Actionsbot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {


    //variables
    private WebDriver driver;
    private Actionsbot actionsbot;

    //locator
    private final By userName = new By.ById("user-name");
    private final By password = new By.ById("password");
    private final By loginButton = new By.ById("login-button");


    //constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionsbot = new Actionsbot(driver);
    }


    //actions

    public LoginPage LoginPage(String user, String pass) {
        actionsbot.type(userName,user);
        actionsbot.type(password,pass);
        actionsbot.click(loginButton);
        return this;
    }


    public HomePage isLoggedIn(String expectedUrl) {
        driver.getCurrentUrl().equals(expectedUrl);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User is not logged in!");
        return new HomePage(driver);
    }
}
