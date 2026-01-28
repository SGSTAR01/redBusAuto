Feature: RedBus ticket booking - search and seat selection
  Background:
    Given the user launches the RedBus application
    And the user is on the RedBus home page

    Scenario Outline: Search buses and select an available seat
      When the user enters the source city as "<fromCity>"
      And the user enters the destination city as "<toCity>"
      And the user selects the journey date as "<journeyDate>"
      And the user clicks on the search buses button
      Then the list of available buses should be displayed

      When the user selects a bus from the search results
      And the user clicks on view seats
      Then the seat layout should be displayed

      When the user selects an available seat
      Then the seat should be marked as selected.

      Examples:
      | fromCity | toCity | journeyDate |
      | Kolkata  | Siliguri | 30-01-2026 |
      | Chennai  | Bangalore | 04-02-2026 |
      | Delhi    | Jaipur    | 06-02-2026 |