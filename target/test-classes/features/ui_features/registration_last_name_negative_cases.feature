@registration_lastname_negative_cases
Feature: Registration_lastname_negative_cases

  Background:
    Given user is on the registration page

  Scenario Outline:
    When user puts in a first name as "<lastname>"
    Then user gets a warning of a blank field entry
    And user closes the browser

    Examples:positive_case
      |lastname|
      ||