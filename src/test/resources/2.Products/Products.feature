Feature: Products

  Scenario: GET - Get All Products
    Given I set an endpoint for GET All Products
    When I request GET All Products
    Then I validate the GET All Products status code is 200

  Scenario: GET - Get Product By ID Positive
    Given I set an endpoint for GET Product By ID Positive
    When I request GET Product By ID Positive
    Then I validate the GET Product By ID Positive status code is 200

  Scenario: GET - Get Product By ID negative
    Given I set an endpoint for GET Product By ID Negative
    When I request GET Product By ID Negative
    Then I validate the GET Product By ID Negative status code is 404

  Scenario: POST - Create Product Positive
    Given I set an endpoint for POST Create Product Positive
    When I request POST Create Product Positive
    Then I validate the POST Create Product Positive status code is 200

  Scenario: POST - Create Product Negative
    Given I set an endpoint for POST Create Product Negative
    When I request POST Create Product Negative
    Then I validate the POST Create Product Negative status code is 400