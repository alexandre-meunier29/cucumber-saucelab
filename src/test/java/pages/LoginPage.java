package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver d) {
        super(d);
        PageFactory.initElements(d, this);
    }


    // Username
    @FindBy(name = "user-name")
    private WebElement userName;

    // password
    @FindBy (id = "password")
    private WebElement password;

    // login
    @FindBy (name = "login-button")
    private WebElement login;

    //error message invalid user + invalid password
    @FindBy (css = ".error-message-container.error")
    private WebElement errorMessageBlock;

    public void enterUserName(String value) {enterValue(userName, value);}

    public void enterPassword(String value) {enterValue(password, value);}

    public void clickOnLogin() {
        click(login);
    }

    public void isErrorMessageDisplayed() {Assert.assertTrue(errorMessageBlock.isDisplayed());}


}
