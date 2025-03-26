Feature: User Login API

  Scenario: Successful login
    Given The API is available
    When I send a login request with email "" and password "cityslicka"
    Then The response status should be 200
    And The response should contain a token
