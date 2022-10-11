@...
Feature: ...
  Background: Connecting to the DB
    Given user connects to the application database
  Scenario: TC01_read_customer_ssn_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "ssn" data
    Then user close the connection