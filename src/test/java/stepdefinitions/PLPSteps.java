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


    @Given("user is logged in successfully and accessed PLP")
    public void user_is_logged_in_successfully_and_accessed_plp() {

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

    @When("user clicks to sort by dropdown and select price low to high")
    public void user_clicks_to_sort_by_dropdown_and_select_price_low_to_high() {
        PLP.sortByPriceLowToHigh();

    }
    @Then("product list is sorted by price ascending")
    public void product_list_is_sorted_by_price_ascending() {

        boolean lowToHighSorted = PLP.verifyPriceLowToHighSorting();
        Assert.assertTrue("Product prices are not sorted in ascending order.", lowToHighSorted);

    }
}
