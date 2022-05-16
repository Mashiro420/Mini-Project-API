Feature: Ratings

  Scenario: GET - Get Product’s Ratings
    Given I set an endpoint for Product’s Ratings
    When I request GET Product’s Ratings
    Then I validate the Product’s Ratings status code is 200

  Scenario: POST - Give Ratings to a Product Positive
    Given I set an endpoint for POST Ratings to a Product Positive
    When I request POST Ratings to a Product Positive
    Then I validate the POST Ratings to a Product Positive status code is 200

  Scenario: POST - Give Ratings to a Product Negative
    Given I set an endpoint for POST Ratings to a Product Negative
    When I request POST Ratings to a Product Negative
    Then I validate the POST Ratings to a Product Negative status code is 500