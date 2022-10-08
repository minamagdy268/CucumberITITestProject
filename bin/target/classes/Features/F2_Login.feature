@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
  Given  user go to login page
  When   user login with valid "test@example.com" and "P@ssw0rd"
  And    user press on login button
  Then   user login to the system successfully

  Scenario: user can't login with invaid  email and password
    Given user go to login page
    When  user login with invalid "test3@test.com" and "123456789"
    And   user press on login button
    Then  user can't login to the system
