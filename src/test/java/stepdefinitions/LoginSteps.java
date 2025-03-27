package stepdefinitions;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver;



    LoginPage loginPage ;

    @Given("user enters valid username")
    public void user_enters_username() {

        loginPage = new LoginPage(Hooks.driver);

        loginPage.enterUserName("standard_user");

    }


    @And("user enters valid password")
    public void user_enters_password() {

        loginPage.enterPassword("secret_sauce");

    }


    @And("user clicks on login button")
    public void user_clicks_on_login() {

        loginPage.clickOnLogin();

    }

    @Then("the user is redirected to the homepage")
    public void home_page_is_displayed() {

        String actualURL =	Hooks.driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(expectedURL, actualURL);

    }

}
