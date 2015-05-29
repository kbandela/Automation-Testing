Feature: This feature add,update and delete items from shopping cart

  @Fakhri
  Scenario: User remove item
    Given user on the homepage
    And the cart has at least one item
    When I view the cart
    And I choose to delete item
    Then the item deleted

  @Fakhri
  Scenario: User update item quantity
    Given user on the homepage
    And the cart has at least one item
    When I view the cart
    And I change the quanity and click update
    Then the total price should be changed

  @Fakhri
  Scenario: User add at least two items in the shopping cart
    Given user on the homepage
    When I choose Herbs & Spices item
    Then I should find one item in my cart
    And the cart page display the first item price
    When I choose Spice Blends items
    Then I should find two items in my cart
    And the cart page display the second item price
