@tag2
Feature: Request an order from a supplier

  As a store owner,
  I want to request an order from a supplier
  So that I can replenish my inventory

  Scenario: Successfully placing an order with a valid supplier
    Given I have a supplier with name "supp1" and a product with name "prod1"
    When owner request an order of 50 units from supplier
    Then successful message shown

  Scenario: Trying to place an order with an invalid supplier
    Given I have a supplier with name "supp2" and a product with name "prod1"
    When owner request an order of 20 units from a supplier "supp3"
    Then the system should show not an instance message

  Scenario: Placing an order with a non-supplier owner
    Given I have a owner with name "owner1" and a product with name "prod1"
    When I request an order of 30 units from owner "owner1"
    Then the system should show not an instance message

  Scenario: Placing an order with zero quantity
    Given I have a supplier with name "supp1" and a product with name "prod1"
    When owner request an order of 0 units from supplier
    Then the system should show invalid quantity message
