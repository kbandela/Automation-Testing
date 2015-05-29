Feature: Finding recipe by keyword
  
  @Preeti
  Scenario: Find recepie by typing keyword TUNA in keyword box
    Given User navigate to the recipe page 
    When I enter tuna in keyword field 
    Then recepie page should display search results by keyword
    
  @Preeti
  Scenario: Find recepie by region
    Given User navigate to the recipe page 
    When I choose Spanish for region
    Then recepie page should display search results by region
    