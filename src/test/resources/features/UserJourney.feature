Feature: Full user journeys

  Scenario: user add a product to basket and go through the full checkout process
    Given user is logged in successfully and accessed PLP
    And user clicks add to basket button on the first listed product
    When user access cart page
    And user clicks the checkout button
    And user adds full name and postcode
    And user clicks continue button
    And user clicks finish button
    Then user is redirected to order confirmation page
    And the order has been placed successfully
