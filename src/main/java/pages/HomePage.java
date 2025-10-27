package pages;

import bots.Actionsbot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    //variables
    private WebDriver driver;
    private Actionsbot actionsbot;

    //locators

    private final By addToCartButton = new By.ByCssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button");
    private final By cartIcon = new By.ByCssSelector("#shopping_cart_container > a > span");

    //constructors
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsbot = new Actionsbot(driver);

    }

    //actions
    public HomePage addToCart() {
        actionsbot.click(addToCartButton);
        return this;
    }

    //validations

    public HomePage validateCartIcon() {
        String cartIconText = actionsbot.getText(cartIcon);
        Assert.assertEquals(cartIconText,"1","Item was not added to the cart!");
        return this;
    }
}
