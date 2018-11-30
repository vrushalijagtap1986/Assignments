Feature: To verify API details

  @APITesting
  Scenario: To verify API operations
    Given I call Get API
    And I call Post API
    Then I call Put API