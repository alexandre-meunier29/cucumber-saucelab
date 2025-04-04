package driver;

import constants.FrameworkConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver initDriver(String browsername, String device, String headlessMode) {

        WebDriver driver;

        switch (browsername) {
            case FrameworkConstants.CHROME_BROWSER:
                driver = initChromeDriver(headlessMode);
                break;

            case FrameworkConstants.FIREFOX_BROWSER :
                driver = initFirefoxDriver(headlessMode);
                break;

            default:
                throw new IllegalStateException("Invalid browser name");

        }
        setDeviceWindowSize(driver, device);
        return driver;
    }

    private static WebDriver initChromeDriver(String headlessMode) {
        ChromeOptions options = new ChromeOptions();

        if ("on".equalsIgnoreCase(headlessMode)) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920x1080");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver initFirefoxDriver(String headlessMode) {
        FirefoxOptions options = new FirefoxOptions();

        if ("on".equalsIgnoreCase(headlessMode)) {
            options.addArguments("-headless");
        }

        return new FirefoxDriver(options);
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
