Feature: Transactions

  Scenario: GET - Get All Transactions
    Given I set an endpoint for GET All Transactions
    When I request GET All Transactions
    Then I validate the GET All Transactions status code is 200

  Scenario: POST - Create Transactions Positive
    Given I set an endpoint for POST Create Transactions Positive
    When I request POST Create Transactions Positive
    Then I validate the POST Create Transactions Positive status code is 200

  Scenario: POST - Create Transactions Negative
    Given I set an endpoint for POST Create Transactions Negative
    When I request POST Create Transactions Negative
    Then I validate the POST Create Transactions Negative status code is 400