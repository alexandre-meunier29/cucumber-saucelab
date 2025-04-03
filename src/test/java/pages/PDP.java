package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PDP extends BasePage{
    public PDP(WebDriver d) {
        super(d);
        PageFactory.initElements(d, this);
    }

    // Locators //

    @FindBy (id = "add-to-cart")
    private WebElement addToCartPDP;

    @FindBy (id = "back-to-products")
    private WebElement backToPLPBtn;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement pricePDP;


    // Methods //

    public void clickAddToCartPDP () {
        click(addToCartPDP);
    }

    public void isBackToPLPVisible () {
        Assert.assertTrue(backToPLPBtn.isDisplayed());
    }

    public double getPDPprice() {
        String priceText = pricePDP.getText().trim();
        priceText = priceText.replaceAll("[^0-9.]", "");
        double productPricePDP = Double.parseDouble(priceText);
        return productPricePDP;
    }
}
