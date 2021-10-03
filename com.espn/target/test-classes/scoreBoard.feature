Feature: As a user, I should be able to navigate to and fetch information from the homepage scoreboard

  Background:
    Given user is at homepage

  @Homepage
  Scenario: User should be able to check how many channels are being shown on the scoreboard
    When the scoreboard is available
    Then user should be able to see all channels being shown on the scoreboard

  @Homepage
  Scenario Outline: User should be able to check if an specific channel is being shown on the scoreboard
    When the scoreboard is available
    Then user should be able to see if "<channel>" is being shown on the scoreboard

    Examples:
      | channel     |
      | ESPN3       |
      | FOX         |
      | NBC         |