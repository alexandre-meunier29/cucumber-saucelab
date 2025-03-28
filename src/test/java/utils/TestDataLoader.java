package utils;

import constants.FrameworkConstants;

import java.util.Properties;

public class TestDataLoader {

    private static TestDataLoader testDataLoader ;

    public static TestDataLoader getInstance() {

        if (testDataLoader == null) {
            testDataLoader = new TestDataLoader();
        }

        return testDataLoader;

    }

    Properties prop;

    private TestDataLoader() {

        switch (FrameworkConstants.ENVIRONMENT) {

            case "Prod" :
                prop = PropertyUtils.propertyUtils(FrameworkConstants.PROD_TEST_DATA_FILE);
                break;

            default:
                break;
        }

    }



    public String getAppURL() {
        return prop.getProperty("appurl");

    }

    public String getUserName() {
        return prop.getProperty("user");

    }

    public String getPassword() {
        return prop.getProperty("password");

    }

}
