@smoke
Feature: F01_Register | users could register with new account
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When  user select gender type
    And   user enter first name "Mena" and last name "QA"
    And   user enter date of birth
    And   user enter email "MenaTester@example.com" field
    And   user fills Password fields "test123456789" and "test123456789"
    And   user clicks on register button
    Then  success message is displayed



