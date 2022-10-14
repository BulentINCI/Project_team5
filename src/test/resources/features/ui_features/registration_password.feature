Feature: Registration password
  
  Background: user is on page
    Given user is on the registration page
    
  Scenario: There should be at least 1 uppercase character
    Given user puts in a ssn "123-23-1234"
    And user puts in a first name as "Mesut"