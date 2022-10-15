@registration_firstname
Feature: Registration_firstname

  Background:
    Given user is on the registration page

  Scenario Outline:
    When user puts in a first name as "<firstname>"
    Then input field does not give any errors
    #And user closes the browser

    Examples:positive_case
     |firstname|
     |ahmet    |
     |ahmet    |
     |A        |
     | A       |
     |XÆA-12   |
     |5        |
     |Mary Jane|
