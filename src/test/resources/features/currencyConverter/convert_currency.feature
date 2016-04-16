Feature: Convert Currency A to a Currency B
  As a Westpac user
  I want to convert currency A to a Currency B and vice versa with the currency converter
  So that I can get an indication of the exchange rates and make an informed decision on my foregn transactions

  Scenario Outline: Convert currency A to B
    Given I am on currency converter page
    When I select <Currency A> from Convert From Drop Down
    And I select <Currency B> from the Convert To Drop DOwn
    And I enter '<Amount>' to the Enter Amount field
    And I click on the Convert button
    Then I should be able to see correct results for the currency conversion in currency converter page

    Examples:
     | Currency A          | Currency B          | Amount |
     |New Zealand Dollar   |United States Dollar |   1    |
     |United States Dollar |New Zealand Dollar   |   1    |
     |Pound Sterling       |New Zealand Dollar   |   1    |
     |Swiss Franc          |Euro                 |   1    |
