Feature: Purchase spice to plate book with four-jar pack

@Kay
  Scenario: Choosing three jars
    Given I am on the home page
    When I search for  spice to plate
    And click on spice to plate link
    When I choose only three jars
    And click buy
    Then a message should be displayed

@Kay
  Scenario: Choosing five jars
    Given I am on the Spice to Plate book with custom four-jar pack page
    When I choose five jars
    And click buy
    Then a message should be displayed

@Kay
  Scenario: Choosing four jars
    Given I am on the Spice to Plate book with custom four-jar pack page
    And select four items for combopack
    And click buy
    Then item should be added to cart
