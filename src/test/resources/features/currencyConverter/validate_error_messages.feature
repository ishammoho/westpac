Feature: Verify currency converter error message
  As a BNZ user
  I want to verify validation error messages
  So that I can verify currency converter displays correct error messages

  Scenario: Verify error message when no amount is entered
    Given I am on currency converter page
    When I enter 'No value' to the Enter Amount field
    Then I should be able to see the following error messages
    """
    Please enter the amount you want to convert.
    """
