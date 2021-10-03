Feature: As a user, I should be able to navigate to terms of use page and download the terms of use

  Background:
    Given user is at homepage

  @Homepage
  Scenario: User should be able to download the terms of use in a PDF file
    And user navigates to terms of use page
    When user clicks on the download PDF button
    Then a PDF file of the terms of use will be downloaded