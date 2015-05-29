Feature: User orders ingredients for a recipe

  @Test
  Scenario: User choose recipe and order all of its ingredients
    Given I am on the home page
    When I choose recipe
    Then I should be able to order ingredients for that recipe
