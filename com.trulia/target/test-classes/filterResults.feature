Feature: As a user, I should be able to filter the results for houses

@Homepage
Scenario Outline: User should be able to filter results based on number of bedrooms
  Given user is at results page for "<cities>"
  When user selects <number_of_bedrooms> number of minimum bedrooms
  Then number of results should change to "<number_of_houses>" to reflect the selected number of minimum bedrooms

Examples:
| number_of_bedrooms      | number_of_houses       |  cities                  |
| 4                       | 536                    |  orlando                 |
| 2                       | 6,888                   |  miami                   |
| 0                       | 1,666                  |  seattle                 |