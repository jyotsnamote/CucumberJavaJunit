Feature: A simple arithmetic calculator

  Scenario: Addition operation
    Given I have a working calculator
    When I perform *addition* operation of 5 and 81
    Then I should get 86

  Scenario: Subtraction operation
    Given I have a working calculator
    When I perform *subtraction* operation of 10 and 14
    Then I should get "-4"

  Scenario: Multiplication operation
    Given I have a working calculator
    When I perform *Multiplication* operation of 10 and 50
    Then I should get 500

  Scenario: Division operation
    Given I have a working calculator
    When I perform *Division* operation of 10 and 5
    Then I should get 2
