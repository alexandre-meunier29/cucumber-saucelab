package driver;

import constants.FrameworkConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver initDriver(String browsername, String device) {

        WebDriver driver;

        switch (browsername) {
            case FrameworkConstants.CHROME_BROWSER:
                driver = new ChromeDriver();
                break;

            case FrameworkConstants.FIREFOX_BROWSER :
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalStateException("Invalid browser name");

        }
        setDeviceWindowSize(driver, device);
        return driver;
    }

    private static void setDeviceWindowSize(WebDriver driver, String device) {
        switch (device.toLowerCase()) {
            case "desktop":
                driver.manage().window().setSize(new Dimension(FrameworkConstants.DESKTOP_WIDTH, FrameworkConstants.DESKTOP_HEIGHT));
                break;

            case "tablet":
                driver.manage().window().setSize(new Dimension(FrameworkConstants.TABLET_WIDTH, FrameworkConstants.TABLET_HEIGHT));
                break;

            case "mobile":
                driver.manage().window().setSize(new Dimension(FrameworkConstants.MOBILE_WIDTH, FrameworkConstants.MOBILE_HEIGHT));
                break;

            default:
                throw new IllegalStateException("Invalid device specified");
        }
    }

}
