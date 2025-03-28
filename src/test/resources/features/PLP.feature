Feature: PLP test cases for saucedemo application

  Scenario: Add the first product from the list to basket
    Given user is logged in successfully and accessed PLP
    When user clicks add to basket button on the first listed product
    Then product is added to basket


  Scenario: Sort the product listing by low to high prices
    Given user is logged in successfully and accessed PLP
    When user clicks to sort by dropdown and select price low to high
    Then product list is sorted by price ascending