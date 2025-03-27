package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriverWait wait ;
    public WebDriver driver;

    public BasePage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(d, Duration.ofSeconds(10));

        PageFactory.initElements(d, this);

    }

    public void click(WebElement element) {

        waitForClicking(element).click();

    }


    public void enterValue(WebElement element , String value) {
        waitForElementToBEVisible(element);
        element.clear();
        element.sendKeys(value);

    }


    private WebElement waitForClicking(WebElement element) {
        return	wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    private WebElement waitForElementToBEVisible(WebElement element) {
        return	wait.until(ExpectedConditions.visibilityOf(element));

    }



}
