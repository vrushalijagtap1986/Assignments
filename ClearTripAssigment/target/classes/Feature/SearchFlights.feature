Feature: Search Flights

  @OneWayFlightSearch
  Scenario: To Search one-way flight
    Given I Launch the ClearTrip application
#    And I click "OneWayRadioButton"
    And I enter "From" Location
    And I enter "To" Location
    And I enter "DepartOn" Date for OneWayTrip
    And I select "Adults"
    And I select "Children"
    And I select "Infants"
    And I click "MoreOptionsLink" in One_RoundTrip
    And I select "ClassOfTravel"
    And I enter "PreferredAirline"
    Then I click "SearchFlightsButton"

  @RoundWayFlightSearch
  Scenario: To Search one-way flight
    Given I Launch the ClearTrip application
    And I click "RoundTripRadioButton"
    And I enter "From" Location
    And I enter "To" Location
    And I enter "DepartOn" Date for RoundTrip
    And I enter "ReturnOn" Date for RoundTrip
    And I select "Adults"
    And I select "Childern"
    And I select "Infants"
    And I click "MoreOptionsLink" in One_RoundTrip
    And I select "ClassOfTravel"
    And I enter "PreferredAirline"
    Then I click "SearchFlightsButton"

