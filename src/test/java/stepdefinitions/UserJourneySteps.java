package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.TestDataLoader;

public class UserJourneySteps {
    LoginPage loginPage ;
    PLP PLP;
    CartPage cartPage;
    CheckoutDetailsPage checkoutDetailsPage;
    CheckoutUserInfoPage checkoutUserInfoPage;
    OrderConfirmationPage orderConfirmationPage;
    private WebDriver driver;

    public UserJourneySteps() {
        driver = Hooks.driver;
        this.loginPage = new LoginPage(driver);
        this.PLP = new PLP(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutDetailsPage = new CheckoutDetailsPage(driver);
        this.checkoutUserInfoPage = new CheckoutUserInfoPage(driver);
        this.orderConfirmationPage = new OrderConfirmationPage(driver);
    }


    @When("user access cart page")
    public void user_access_cart_page() {
       PLP.clickCartButton();

    }
    @When("user clicks the checkout button")
    public void user_clicks_the_checkout_button() {
        cartPage.clickCheckoutButton();

    }
    @When("user adds full name and postcode")
    public void user_adds_full_name_and_postcode() {

        String firstname = TestDataLoader.getInstance().getFirstName();
        String lastname = TestDataLoader.getInstance().getLastName();
        String postcode = TestDataLoader.getInstance().getPostCode();

        checkoutUserInfoPage.enterFirstName(firstname);
        checkoutUserInfoPage.enterLastName(lastname);
        checkoutUserInfoPage.enterPostCode(postcode);

    }
    @When("user clicks continue button")
    public void user_clicks_continue_button() {
        checkoutUserInfoPage.clickOnContinue();

    }
    @When("user clicks finish button")
    public void user_clicks_finish_button() {
        checkoutDetailsPage.clickOnFinishButton();

    }
    @Then("user is redirected to order confirmation page")
    public void user_is_redirected_to_order_confirmation_page() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        assert (actualURL.contains(expectedURL));

    }
    @Then("the order has been placed successfully")
    public void the_order_has_been_placed_successfully() {
        orderConfirmationPage.isOrderSuccess();

    }
}
