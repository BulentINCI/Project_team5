@ssn_negative_scenarios
Feature:

  Background:
    Given user is on the registration page

  Scenario Outline:

    When user puts in a ssn "<ssn>" and moves to next field
    Then user gets a warning of an invalid field entry

    Examples:
      |ssn        |
      |12-2424-123|
      |123-424-123|
      |123-4-34123|
      |456-424-1232|
      |123-424-123|
      |123-424-23|
      |000-23-4235|
      |900-24-1423|
      |956-24-1243|
      |666-24-1423|
      |34.-42-1523|
      |54?-42-1523|
      |65&-42-1523|
      |34A-42-1523|

