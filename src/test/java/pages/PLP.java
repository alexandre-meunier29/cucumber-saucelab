package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PLP extends BasePage{
    public PLP(WebDriver d) {
        super(d);
    }

// first product add to basket
    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[text()='Add to cart']")
    private WebElement firstProduct;

    //Cart badge count
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    // return cart badge product count
    public int getCartBadgeCount() {
        return Integer.parseInt(cartBadge.getText());
    }


    // add first product to basket method
    public void addFirstProductToBasket() {
        click(firstProduct);
    }


}
