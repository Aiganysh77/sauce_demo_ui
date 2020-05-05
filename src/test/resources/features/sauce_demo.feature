Feature: Sauce_demo UI testing


  @addingandremovingitem
  Scenario: Validating adding and removing items
    Given User logs into the Application
    And User sorts the items by low price to high
    And User adds three items to the shopping cart
    And User visits the shopping cart
    Then User verifies the items that were added into the cart
    Given User removes one item from shopping cart
    And User adds another item to the shopping cart
    Then User checks out
    And User verifies the purchased items are correct
    And User verifies total price is correct
    Then User checks out of application
