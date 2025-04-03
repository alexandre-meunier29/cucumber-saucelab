# Test Automation Framework

## Overview

This framework is designed for automating tests on web applications, with a focus on performance, functional, and regression testing. It uses Selenium WebDriver, Cucumber for BDD, and other essential tools to provide an efficient testing process. The framework is highly configurable and follows industry best practices.

## **Technologies Used**

- **Selenium WebDriver**: For browser automation.
- **Cucumber**: For Behavior-Driven Development (BDD) scenarios.
- **JUnit**: For running test cases and assertions.
- **Maven**: For managing dependencies.
- **WebDriverManager**: To handle driver binaries automatically.
- **Jenkins**: For Continuous Integration (CI).
- **TestNG**: For managing test configurations and parallel test execution.

## **Configuration Files**

### **config.properties**
This file contains the configuration values such as the browser type and environment settings.

`config.properties`:
- **browser**: The browser to be used for testing (Chrome, Firefox, etc.).
- **environment**: The environment to use for testing (e.g., Prod, Staging).
- **device**: Define the size of your window (desktop, tablet, mobile)

Desktop: 1920x1080,
Tablet (Portrait): 768x1024,
Mobile (Portrait): 360x640

### **prod_test_data.properties**
In the `prod_test_data.properties` file, you define the test data that will be used across your tests. This file is located in the `src/test/resources/config/` directory.

**Example `prod_test_data.properties`:**

```properties
# URL for the application under test
appurl=https://www.saucedemo.com/

# Login credentials
user=standard_user
password=secret_sauce

# Customer details for checkout
firstname=Alex
lastname=Doe
postcode=NW42RE
```
## Explanation of Test Data Fields:

- **appurl**: The URL of the application under test (in this case, the Sauce Demo site).
- **user**: The username used for login during tests.
- **password**: The password used for login.
- **firstname**: The first name of the customer for testing checkout functionality.
- **lastname**: The last name of the customer for testing checkout functionality.
- **postcode**: The postal code of the customer for testing checkout functionality.

These values are read from the `prod_test_data.properties` file and used in the tests accordingly. For example, the user and password can be used to perform login steps in your BDD scenarios.

## How to Run the Tests

1. Clone the repository to your local machine.
2. Ensure that you have the necessary dependencies by running `mvn install` in the root directory.
3. The test suite is configured to run with Cucumber and JUnit.
4. You can run the test directly from the gherkins files located in feature folder
5. Or use the runner in the runners package

## License

This project is licensed under the [MIT License](LICENSE). You are free to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, as long as you include the original copyright notice and this permission notice in all copies or substantial portions of the Software.

The software is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages, or other liability, whether in an action of contract, tort, or otherwise, arising from, out of, or in connection with the software or the use or other dealings in the software.


