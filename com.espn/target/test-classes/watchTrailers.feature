Feature: As a user, I should be able to navigate and watch trailers

  Background:
    Given user is at homepage

  @Homepage
  Scenario Outline: User should be able to navigate and watch trailers
    When user navigates to the watch page
    And user navigates to the trailers section
    And user selects <slot> trailer slot
    Then user should be taken to the selected trailer embedded media player

    Examples:
      | slot    |
      | 1       |
      | 3       |
      | 5       |
