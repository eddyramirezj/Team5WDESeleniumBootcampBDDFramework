#Feature: As a user, I should be able to drag and drop the chat-with-us dialog box
#
#  Background:
#    Given user is at homepage
#
#  @Homepage
#  Scenario Outline: User should be able to drag and drop the chat-with-us dialog box
#    When user navigates to the business page
#    And clicks on maximizing the chat-with-us dialog box
#    And clicks and holds on the chat-with-us dialog box
#    Then user should be able to drag and drop to <xOffset> and <yOffset> the chat-with-us dialog box
#
#    Examples:
#      | xOffset     |  yOffset      |
#      | -500        |     300       |
#      | -50         |      50       |
#      | -500        |      100      |