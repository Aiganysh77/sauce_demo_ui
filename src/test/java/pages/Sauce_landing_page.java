package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Sauce_landing_page {

    public Sauce_landing_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement sortBox;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[2]")
    public WebElement addToCardbikelight;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[3]")
    public WebElement addToCardredShirt;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[4]")
    public WebElement addToCardJacket;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
    public WebElement Tshirt;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    public WebElement backpack;

    @FindBy(xpath = "//div[.='Sauce Labs Bike Light']")
    public WebElement bikeLight;

    @FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']")
    public WebElement redTshirt;

    @FindBy(xpath = "//div[.='Sauce Labs Fleece Jacket']")
    public WebElement jacket;

    @FindBy(xpath = "(//div[@id='shopping_cart_container'])//a")
    public WebElement shoppingCart;

    @FindBy(xpath = "(//button[@class='btn_secondary cart_button'])[1]")
    public WebElement remove1;

    @FindBy(xpath = "//a[@class='btn_secondary']")
    public WebElement continueShopping;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'])[1]")
    public WebElement addToCardBackpack;

    @FindBy(xpath = "//a[.='CHECKOUT']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//div[.='15.99']")
    public WebElement redTshirtprice;

    @FindBy(xpath = "//div[.='49.99']")
    public WebElement jackettprice;

    @FindBy(xpath = "//div[.='29.99']")
    public WebElement backpackprice;

}
