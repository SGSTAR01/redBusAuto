Feature: RedBus ticket booking - search and seat selection

  Scenario Outline: Search buses and select an available seat
    Given the user launches the RedBus application
    And the user is on the RedBus home page
    When the user enters the source city as "<fromCity>"
    And the user clicks on the boarding point as "<fromBoarding>"
    And the user enters the destination city as "<toCity>"
    And the user clicks on the boarding point as "<toBoarding>"
    And the user selects the journey date as "<journeyDate>"
    And the user clicks on the search buses button
    Then the list of available buses should be displayed

    When the user selects a bus from the search results
    Then the seat layout should be displayed

    When the user selects an available seat
    Then the seat should be marked as selected.

    Examples:
      | fromCity | toCity   | fromBoarding | toBoarding                       | journeyDate  |
      | Kolkata  | Siliguri | Esplanade    | Tenzing Norgay Central Bus Stand | 1 March 2026 |
      | Chennai  | Bangalore | CMBT         | Majestic                         | 12 February 2026 |
      | Delhi    | Jaipur    | Badarpur     | Sindhi Camp                      | 6 March 2026     |