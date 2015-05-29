Feature: Finding Store Location

  @Kay
  Scenario: Clicking the image of map
    Given when I am on location page
    When I click on the image of Illinois map
    And Click on the Chicago Lincoln Square link
    Then Chicago Lincoln Square store details should be displayed
