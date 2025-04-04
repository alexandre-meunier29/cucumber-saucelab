package hooks;

import constants.FrameworkConstants;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtils;
import utils.TestDataLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public static WebDriver driver ;

    @Before
    public static void beforeHooks() {

        Properties properties = 	PropertyUtils.propertyUtils(FrameworkConstants.CONFIG_FILE_PATH);

        FrameworkConstants.BROWSER =  properties.getProperty("browser");
        FrameworkConstants.ENVIRONMENT =  properties.getProperty("environment");
        FrameworkConstants.DEVICE = properties.getProperty("device");
        String headlessMode = properties.getProperty("headless");

        driver	= DriverFactory.initDriver(FrameworkConstants.BROWSER, FrameworkConstants.DEVICE, headlessMode);
        logBrowserAndViewportDetails(FrameworkConstants.BROWSER, FrameworkConstants.DEVICE);
        driver.get(TestDataLoader.getInstance().getAppURL());

    }


    @After
    public void afterHooks() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture the screenshot if the step failed
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Save screenshot to desired location
                File screenshotLocation = new File("target/screenshots/" + scenario.getName() + "_failure.png");
                FileUtils.copyFile(screenshot, screenshotLocation);
                // Attach the screenshot to Allure
                attachScreenshotToAllure(screenshotLocation);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to attach screenshot to Allure report
    private void attachScreenshotToAllure(File screenshot) {
        try (FileInputStream screenshotInputStream = new FileInputStream(screenshot)) {
            // Add screenshot attachment to Allure
            Allure.addAttachment("Screenshot", "image/png", screenshotInputStream, ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Browser: {0}, Viewport: {1}")
    public static void logBrowserAndViewportDetails(String browser, String device) {
        // Log the browser type and viewport size to Allure
        Allure.addAttachment("Browser", browser);
        Allure.addAttachment("Viewport", getViewportDimensions(device));
    }

    private static String getViewportDimensions(String device) {
        String viewport = "";
        switch (device.toLowerCase()) {
            case "desktop":
                viewport = FrameworkConstants.DESKTOP_WIDTH + "x" + FrameworkConstants.DESKTOP_HEIGHT;
                break;
            case "tablet":
                viewport = FrameworkConstants.TABLET_WIDTH + "x" + FrameworkConstants.TABLET_HEIGHT;
                break;
            case "mobile":
                viewport = FrameworkConstants.MOBILE_WIDTH + "x" + FrameworkConstants.MOBILE_HEIGHT;
                break;
            default:
                throw new IllegalStateException("Invalid device specified");
        }
        return viewport;
    }



}