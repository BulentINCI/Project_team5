@user_registration @NegativeRegistrationAttempts
Feature: Negative_User_Registration_Attempt

  Background:
    Given user is on the registration page

  Scenario Outline:

    When user puts in a ssn "<ssn>"
    And user puts in a first name as "<firstname>"
    And user puts in a last name as "<lastname>"
    And user puts in a username as "<username>"
    And user puts in an email as "<email>"
    When user puts in "<password>" and confirm the new password
    And user registers the information
    Then registration is not completed successfully

    Examples:
      |ssn        |firstname|lastname|username|email          |password|
      |           |ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |77-845-6789|ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |777-8-46789|ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |777-8-467891|ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |7-8-467891 |ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |7-8445-6789|ahmet    |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |778-45-6789|         |kayad    |akayaad   |akayas@email.com|Adfg123@.|
      |778-85-6789|a        |         |akayaad   |akayas@email.com|Adfg123@.|
      |778-85-6789|a        |k        |          |akayas@email.com|Adfg123@.|
      |778-85-6789|a        |k        |akayaad   |                |Adfg123@.|
      |778-85-6789|a        |k        |akayaad   |akayas@         |Adfg123@.|
      |778-85-6789|a        |k        |akayaad   |akayas@email.com|         |
      |778-85-6789|a        |k        |akayaad   |akayas@email.com|A        |
      |778-85-6789|a        |k        |akayaad   |akayas@email.com|Asd      |
