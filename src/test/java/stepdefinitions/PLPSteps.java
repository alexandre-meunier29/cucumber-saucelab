package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PLP;
import utils.TestDataLoader;

public class PLPSteps {

    LoginPage loginPage ;
    PLP PLP;
    private WebDriver driver;


    @Given("user is logged in successfully")
    public void user_is_logged_in_successfully() {

        driver = Hooks.driver;
        loginPage = new LoginPage(driver);

        String username = TestDataLoader.getInstance().getUserName();
        String password = TestDataLoader.getInstance().getPassword();

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogin();
        PLP = new PLP(driver);

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL, currentURL);


    }
    @When("user clicks add to basket button on the first listed product")
    public void user_clicks_add_to_basket_button_on_the_first_listed_product() {
        PLP.addFirstProductToBasket();


    }
    @Then("product is added to basket")
    public void product_is_added_to_basket() {
        PLP.getCartBadgeCount();
        Assert.assertEquals(1, PLP.getCartBadgeCount());

    }
}
