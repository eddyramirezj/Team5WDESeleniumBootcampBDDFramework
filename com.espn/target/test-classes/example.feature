Feature: As a user, I should be able to navigate and watch trailers

  Background:
    Given user is at homepage

  @Homepage
  Scenario: User should be able to navigate and watch trailers
    When user navigates to the watch page
    And user navigates to the trailers section
    And user selects a trailer slot
    Then user should be taken to the selected trailer embedded media player

#    Examples:
#      | search term    |           category              |
#      | Playstation 5  |      Video Games & Consoles     |
#      | Hand Sanitizer |        Health & Beauty          |
#      | iPhone 13      |    Cell Phones & Accessories    |
