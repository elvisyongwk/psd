Feature: Display Asian Cuisine in Menu
  Scenario: View asian cuisine menu
    Given users wants to view "asian" cuisine menu
    When users selected "asian" cuisine menu
    Then display asian cuisine "food1"