Feature: cart page test cases for saucedemo application.

  Scenario: first product removal from cart page
    Given user is logged in successfully and accessed PLP
    And user clicks add to basket button on the first listed product
    And user access cart page
    When user clicks remove button on the first listed product
    Then product is removed from cart
