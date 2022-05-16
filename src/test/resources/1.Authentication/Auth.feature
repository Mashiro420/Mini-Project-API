Feature: Authentication

  Scenario Outline: POST - Register
    Given I set an endpoint for POST new "<fullname>" with "<email>" and "<password>"
    When I request POST register
    Then I validate register status code is <status_code>
    Examples:
      |fullname|email|password|status_code|
      |test    |new  |test    |200        |
      |test    |same |test    |400        |

  Scenario Outline: POST - Login
    Given I set an endpoint for POST "<email>" and "<password>"
    When I request POST login
    Then I validate login status code is <status_code>
    And get token if "<message>" for other request
    Examples:
      |email|password|status_code|message|
      |same |test    |200        |success|
      |new  |test    |400        |failed|