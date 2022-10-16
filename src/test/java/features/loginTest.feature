Feature: to test login feature

  @Assignment
  Scenario Outline: Verify that user cannot log in with valid but not registered email
    Given I am on landing page
    When I click on sing in button
    And I enter email address as "<email>" and click on continue
    Then I verify error message is displayed as "<error>"

    Examples: 
      | email                     | error                                             |
      | qaautomation365@gmail.com | We cannot find an account with that email address |
