@registration_name_negative_cases
Feature: Registration_name_negative_cases

  Background:
    Given user is on the registration page

  Scenario Outline:
    When user puts in a first name as "<firstname>"
    Then user gets a warning of a blank field entry
    And user closes the browser

    Examples:positive_case
      |firstname|
      ||