@user_registration
Feature: Successful_User_Registration

  Background:
    Given user is on the registration page

  Scenario Outline:Positive_scenario
    When user puts in a ssn "<ssn>"
    And user puts in a first name as "<firstname>"
    And user puts in a last name as "<lastname>"
    And user puts in a username as "<username>"
    And user puts in an email as "<email>"
    When user puts in "<password>" and confirm the new password
    And user registers the information
    Then registration is complete

    Examples:
      |ssn        |firstname|lastname|username|email          |password|
      |779-45-6789|ahmet    |kaya    |akayaa   |akaya@email.com|Adfg123@.|


