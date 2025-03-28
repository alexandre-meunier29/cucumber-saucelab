package hooks;

import constants.FrameworkConstants;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
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
        driver	= DriverFactory.initDriver(FrameworkConstants.BROWSER);
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