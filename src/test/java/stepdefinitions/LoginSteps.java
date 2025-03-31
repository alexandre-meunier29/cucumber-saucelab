package stepdefinitions;
import hooks.Hooks;
import utils.TestDataLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {

    LoginPage loginPage ;
    private WebDriver driver;

    public LoginSteps() {
        driver = Hooks.driver;
        this.loginPage = new LoginPage(driver);
    }


    @Given("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

        String username = TestDataLoader.getInstance().getUserName();
        String password = TestDataLoader.getInstance().getPassword();

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
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

    @Given("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {

        loginPage.enterUserName("Dummy-user");
        loginPage.enterPassword("dummy-password");

    }
    @Then("the user is not logged in and get error message")
    public void the_user_is_not_logged_in_and_get_error_message() {
        loginPage.isErrorMessageDisplayed();

    }

}
