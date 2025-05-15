Feature: Bank account operations

  Scenario: Make a deposit
    Given I have an empty bank account
    When I deposit 100 euros
    Then the account balance should be 100 euros

  Scenario: Make multiple deposits
    Given I have an empty bank account
    When I deposit 50 euros
    And I deposit 150 euros
    Then the account balance should be 200 euros

  Scenario: Make a withdrawal
    Given I have a bank account with 200 euros
    When I withdraw 50 euros
    Then the account balance should be 150 euros

  Scenario: Withdraw entire balance
    Given I have a bank account with 100 euros
    When I withdraw 100 euros
    Then the account balance should be 0 euros

  Scenario: Show statement with multiple operations
    Given I made the following operations:
      | date       | amount |
      | 2025-01-01 |  200   |
      | 2025-01-02 | -50    |
    When I request the statement
    Then the output should be:
      """
      DATE       | AMOUNT | BALANCE
      01/01/2025 |  200   | 200
      02/01/2025 | -50    | 150
      """
