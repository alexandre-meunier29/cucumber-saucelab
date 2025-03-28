Feature: PLP test cases for saucedemo application

  Scenario: Add the first product from the list to basket
    Given user is logged in successfully
    When user clicks add to basket button on the first listed product
    Then product is added to basket