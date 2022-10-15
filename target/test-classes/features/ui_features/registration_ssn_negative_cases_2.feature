@ssn_negative_scenarios
Feature:

  Background:
    Given user is on the registration page

  Scenario Outline:

    When user puts in a ssn "<ssn>" and moves to next field
    Then user gets a warning of a blank field entry

    Examples:
      |ssn        |
      |           |