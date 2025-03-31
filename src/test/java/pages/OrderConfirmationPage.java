package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver d) {
        super(d);
        PageFactory.initElements(d, this);
    }

    // Locators //

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    @FindBy(xpath = "//h2 [@class='complete-header']")
    private WebElement orderSuccessH2;

    // Methods //

    public boolean isOrderSuccess() {
        return orderSuccessH2.isDisplayed() && orderSuccessH2.getText().equalsIgnoreCase("Thank you for your order!");

    }
}
