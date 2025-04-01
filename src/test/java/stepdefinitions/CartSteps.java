package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartSteps {

    CartPage CartPage;
    private WebDriver driver;

    public CartSteps() {
        driver = Hooks.driver;
        this.CartPage = new CartPage(driver);

    }

    @When("user clicks remove button on the first listed product")
    public void user_clicks_remove_button_on_the_first_listed_product() {
        CartPage.clickRemoveFirstProduct();
    }
    @Then("product is removed from cart")
    public void product_is_removed_from_cart() {
        CartPage.isItemDisplayed();
    }



}
