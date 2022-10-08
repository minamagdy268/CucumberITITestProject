@smoke
  Feature: F3_Reset password
    Scenario: User could reset password successfully
    Given user open login page
    When  user click on Forgot Password?
    And   user enter valid "MenaTester@example.com"
    And   user click on RECOVER button
    Then  Email with instructions will be sent