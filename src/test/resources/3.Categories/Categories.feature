Feature: Categories

  Scenario: GET - Get All Categories
    Given I set an endpoint for GET All Categories
    When I request GET All Categories
    Then I validate the GET All Categories status code is 200

  Scenario: POST - Create Categories Positive
    Given I set an endpoint for POST Create Categories Positive
    When I request POST Create Categories Positive
    Then I validate the POST Create Categories Positive status code is 200

  Scenario: POST - Create Categories Negative
    Given I set an endpoint for POST Create Categories Negative
    When I request POST Create Categories Negative
    Then I validate the POST Create Categories Negative status code is 500