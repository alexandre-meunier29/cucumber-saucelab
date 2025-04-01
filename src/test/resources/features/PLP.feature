Feature: PLP test cases for saucedemo application

  Scenario: Add the first product from the list to basket
    Given user is logged in successfully and accessed PLP
    When user clicks add to basket button on the first listed product
    Then product is added to basket

  Scenario: Add the the cheapest product from the list to basket
    Given user is logged in successfully and accessed PLP
    When user clicks add to basket button on the cheapest listed product
    Then product is added to basket

  Scenario: Add the most expensive product from the list to basket
    Given user is logged in successfully and accessed PLP
    When user clicks add to basket button on the most expensive listed product
    Then product is added to basket

  Scenario: Sort the product listing by low to high prices
    Given user is logged in successfully and accessed PLP
    When user clicks to sort by dropdown and select price low to high
    Then product list is sorted by price ascending

  Scenario: Accessing product page from PLP
    Given user is logged in successfully and accessed PLP
    When user clicks on the first product of the list
    Then user is redirected to PDP

  Scenario: Add multiple products to the cart
    Given user is logged in successfully and accessed PLP
    When user clicks add to basket button on the first listed product
    And user clicks add to basket button on the third listed product
    Then two products are added to basket