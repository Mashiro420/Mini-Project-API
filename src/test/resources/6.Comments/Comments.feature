Feature: Comments

  Scenario: GET - Get Product’s Comments
    Given I set an endpoint for GET Product’s Comments
    When I request GET Product’s Comments
    Then I validate GET Product’s Comments status code is 200

  Scenario: POST - Write Comment to a Product Positive
    Given I set an endpoint for POST Comment to a Product Positive
    When I request POST Comment to a Product Positive
    Then I validate the POST Comment to a Product Positive status code is 200

  Scenario: POST - Write Comment to a Product Negative
    Given I set an endpoint for POST Comment to a Product Negative
    When I request POST Comment to a Product Negative
    Then I validate the POST Comment to a Product Negative status code is 500