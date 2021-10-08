Feature: As a user, I should be able to search for houses in different cities and different categories

  Background:
    Given user is at homepage

  @Homepage
  Scenario Outline: User should be able to search for houses to buy
    When user enters "<cities_for_sale>" city in the search bar
    And user selects a city from the list of populated cities
    Then user should be taken to the list of "<number_of_houses>" houses for the specified city

    Examples:
      | cities_for_sale         |   number_of_houses |
      | Miami                   |   9,450            |
      | Nashville               |   1,443            |
      | Seattle                 |   1,653            |

  @Homepage
  Scenario Outline: User should be able to search for houses to rent
    When user clicks on rent tab for houses to rent
    And user enters "<cities_for_rent>" city in the search bar
    And user selects a city from the list of populated cities
    Then user should be taken to the list of "<number_of_dwellings>" dwellings for Rent for the specified city

    Examples:
      | cities_for_rent           |   number_of_dwellings |
      | New York                  |   12,578               |
      | Orlando                   |   682                |
      | Chicago                   |   7,801               |

  @Homepage
  Scenario Outline: User should be able to search for sold houses
    When user clicks on sold tab for houses sold
    And user enters "<cities_with_sold_houses>" city in the search bar
    And user selects a city from the list of populated cities
    Then user should be taken to the list of "<number_of_sold_houses>" sold houses for the specified city

    Examples:
      | cities_with_sold_houses  |   number_of_sold_houses  |
      | San Francisco            |   7,757                  |
      | Buffalo                  |   7,046                  |
      | Las Vegas                |   4,195                  |