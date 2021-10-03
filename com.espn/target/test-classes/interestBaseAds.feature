Feature: As a user, I should be able to opt out of advertisement choices

  Background:
    Given user is at homepage

  @Homepage
  Scenario: User should be able to opt out of advertisement choices
    And user navigates to interest base ads page
    When user clicks on the select all available opt-outs
    Then all available opt-out choices should be selected