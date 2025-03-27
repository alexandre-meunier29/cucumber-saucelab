Feature: Login test cases for saucedemo application.

  Scenario: Successful login with valid credentials
    Given user enters valid username
    And user enters valid password
    And user clicks on login button
    Then the user is redirected to the homepage