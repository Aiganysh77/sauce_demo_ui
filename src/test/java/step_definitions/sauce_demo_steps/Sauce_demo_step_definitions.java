package step_definitions.sauce_demo_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Sauce_landing_page;
import utilities.Config;
import utilities.Driver;

import javax.swing.*;
import java.util.List;

public class Sauce_demo_step_definitions {

    Sauce_landing_page sl = new Sauce_landing_page();


    @Given("User logs into the Application")
    public void user_logs_into_the_Application() {
        Driver.getDriver().get(Config.getProperty("url"));
        sl.username.sendKeys(Config.getProperty("username"));
        sl.password.sendKeys(Config.getProperty("password"));
        sl.loginButton.click();

    }

    @Given("User sorts the items by low price to high")
    public void user_sorts_the_items_by_low_price_to_high() throws InterruptedException {
        Select sort = new Select(sl.sortBox);
        sort.selectByIndex(2);


    }

    @Given("User adds three items to the shopping cart")
    public void user_adds_three_items_to_the_shopping_cart() throws InterruptedException {
        sl.addToCardbikelight.click();
        sl.addToCardredShirt.click();
        sl.addToCardJacket.click();


    }

    @Given("User visits the shopping cart")
    public void user_visits_the_shopping_cart() {
        sl.shoppingCart.click();

    }

    @Then("User verifies the items that were added into the cart")
    public void user_verifies_the_items_that_were_added_into_the_cart() {
        Assert.assertTrue("bike is not in the cart",sl.bikeLight.isDisplayed());
        Assert.assertTrue("red t-shirt is not in the cart", sl.redTshirt.isDisplayed());
        Assert.assertTrue("Jacket is not in the cart", sl.jacket.isDisplayed());

    }

    @Given("User removes one item from shopping cart")
    public void user_removes_one_item_from_shopping_cart() {
        sl.remove1.click();

    }

    @Given("User adds another item to the shopping cart")
    public void user_adds_another_item_to_the_shopping_cart() {
      sl.continueShopping.click();
      sl.addToCardBackpack.click();
    }

    @Then("User checks out")
    public void user_checks_out() {
      sl.shoppingCart.click();
      sl.checkoutButton.click();
      sl.shoppingCart.click();
    }
    @Then("User verifies the purchased items are correct")
    public void user_verifies_the_purchased_items_are_correct() {

        Assert.assertTrue("wrong product", sl.jacket.isDisplayed());
        Assert.assertTrue("wrong product", sl.redTshirt.isDisplayed());
        Assert.assertTrue("wrong product", sl.backpack.isDisplayed());
    }

    @Then("User verifies total price is correct")
    public void user_verifies_total_price_is_correct() {
     double totalPrice = 95.97;

     double actualTotalPrice = Double.parseDouble(sl.backpackprice.getText())+ Double.parseDouble(sl.redTshirtprice.getText())
             + Double.parseDouble(sl.jackettprice.getText());


     Assert.assertEquals("total price is wrong",totalPrice, actualTotalPrice, 0);

    }

    @Then("User checks out of application")
    public void user_checks_out_of_application() {
        sl.checkoutButton.click();

    }



}
