Feature: PDP test cases for saucedemo application

  Scenario: Add the first product from the list to basket from product page
    Given user is logged in successfully and accessed PLP
    And user clicks on the first product of the list
    And user is redirected to PDP
    When user clicks add to basket button
    Then product is added to basket