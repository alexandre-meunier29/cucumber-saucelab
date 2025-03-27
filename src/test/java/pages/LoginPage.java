package pages;

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

    public void enterUserName(String value) {
        enterValue(userName, value);

    }


    public void enterPassword(String value) {
        enterValue(password, value);

    }


    public void clickOnLogin() {
        click(login);
    }




}
