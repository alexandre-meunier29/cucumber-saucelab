package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PDP;

public class PDPSteps {

    PDP PDP;
    private WebDriver driver;

    public PDPSteps() {
        driver = Hooks.driver;
        this.PDP = new PDP(driver);

    }

    @Given("user is redirected to PDP")
    public void user_is_redirected_to_pdp() {
        Allure.step("redirected to pdp by checking 'Back to PLP' button visibility");
        PDP.isBackToPLPVisible();
    }
    @When("user clicks add to basket button")
    public void user_clicks_add_to_basket_button() {
        Allure.step("clicks on 'add to basket' button");
        PDP.clickAddToCartPDP();
    }
}
