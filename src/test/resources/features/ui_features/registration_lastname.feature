@registration_lastname
Feature: Registration_lastname

  Background:
    Given user is on the registration page

  Scenario Outline:
    When user puts in a last name as "<lastname>"
    Then input field does not give any errors
    #And user closes the browser

    Examples:positive_case
      |lastname|
      |yilmaz  |
      |Yilmaz   |
      |123       |
      |Kara Can  |
      | XÆA-12   |
      |Johnson-Huelvw|
      |S#gh|