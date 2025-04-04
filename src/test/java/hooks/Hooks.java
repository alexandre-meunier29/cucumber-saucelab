package hooks;

import constants.FrameworkConstants;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtils;
import utils.TestDataLoader;

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
        driver.get(TestDataLoader.getInstance().getAppURL());

    }


    @After
    public void afterHooks() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}