Feature: This feature tests saving shopping cart for a particular user

  @Fakhri
  Scenario: User login to add an item
    Given user on the homepage
    When I login to the system
    And I choose Herbs & Spices item
    Then I should find one item in my cart
    When I logout from the system
    And I login to the system
    Then the cart has at least one item
