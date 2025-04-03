Feature: Verify Product Price Consistency

  Scenario: Verify product price across PLP, PDP, Cart Page and Checkout
    Given user is logged in successfully and accessed PLP
    Then the price of the first product on the PLP should be captured

    When user clicks on the first product of the list
    Then the price on the PDP should be the same as the price captured from the PLP

    When user clicks add to basket button
    And user access cart page
    Then the product should appear in the cart as the same price as captured from the PLP

    When user clicks the checkout button
    And user adds full name and postcode
    And user clicks continue button
    Then the product should appear in the checkout as the same price as captured from the PLP