@user_registration1
Feature: Registration
  
  Background:
    Given user is on the registration page

  Scenario Outline:Positive_scenario
    When user puts in a ssn "<ssn>" and moves to next field
    Then input field does not give any errors
    And user closes the browser

    Examples:
      |ssn        |firstname|lastname|username|email          |password|
      |779-45-6789|ahmet    |kaya    |akayaa   |akaya@email.com|Adfg123@.|