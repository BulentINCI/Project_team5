@api
Feature: checking_if_registrant_saved

#  Scenario:
#    Given user sends a get request for users
#    And   user converts user records to Java
#    Then user validates user data

  Scenario Outline:

    Given user puts in "<Ssn>""<firstName>""<lastName>""<email>""<username>""<password>" information
    And user registers the information
    Then database is checked whether the user is registered all correctly
  Examples:
    |Ssn|firstName|lastName|email|username|password|
    |323-45-1740|omer|fhanca|c2346@ail.com|ftanca|oKanca+23?|