Feature: As a user, I should be able to click on all homepage links

  Background:
    Given user is at homepage

  @Homepage
  Scenario: User should be able to click on trade-in promotion
    When clicks on tradeIn information button
    Then a modal window should appear at the top of the page with the necessary information

  @Homepage @Language
  Scenario: User should be able to change language to Spanish
    When clicks on change to Spanish language button
    Then homepage language should change to Spanish

  @Homepage @Language
  Scenario: User should be able to change language to English
    When clicks on change to Spanish language button
    And clicks on change to English language button
    Then homepage language should change to English

  @Homepage @Ratings
  Scenario Outline: User should be able to submit a rating
    When User clicks on feedback tab
    And User selects "<rating>" rating number
    And User selects a purpose of visit option from the menu
    And User clicks on Submit button
    Then message "Thank You For Providing Feedback" should appear

    Examples:
      | rating     |
      | four       |
      | seven      |
      | ten        |