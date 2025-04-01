Feature: Login test cases for saucedemo application.

  Scenario: Successful login with valid credentials
    Given user enters valid username and password
    And user clicks on login button
    Then the user is redirected to the homepage

  Scenario: Unsuccessful login with invalid credentials
    Given user enters invalid username and password
    And user clicks on login button
    Then the user is not logged in and get error message

  Scenario: Logout
    Given user is logged in successfully and accessed PLP
    When user clicks logout button from the side menu
    Then user is redirected to login page