Feature: Verify currency converter error message
  As a Westpac user
  I want to verify validation error messages
  So that I can verify currency converter displays correct error messages

  Scenario: Verify error message when no amount is entered
    Given I am on currency converter page
    When I enter '0' to the Enter Amount field
    And I click on the Convert button
    Then I should be able to see the following error messages
    """
    Please enter the amount you want to convert.
    """