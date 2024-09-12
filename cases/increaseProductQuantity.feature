@tag2
Feature: Increase product quantity
  As a store owner or supplier,
  I want to increase the quantity of my products by name
  So that I can update inventory levels

  Scenario: Successfully increase the quantity of a product
    Given a product have name "Product1" exists and belongs to the user and quantity of 10
    When the user increases the product "Product1" quantity by 5
    Then successful operation message should be shown

  Scenario: Fail to increase the quantity of a product that does not exist
    Given a product have name "NonExistentProduct" does not exist
    When the user tries to increase the product "Product100" quantity by 5
    Then an invalid name message shown

  Scenario: Fail to increase the quantity of a product that does not belong to the user
    Given a product have name "Product2" exists but does not belong to the user
    When the user tries to increase the product "Product2" quantity by 5
    Then an invalid permission message shown

  Scenario: Fail to increase the product quantity with a negative number
    Given a product have name "Product1" exists and belongs to the user and quantity of 10
    When the user tries to increase the product "Product1" quantity by -5
    Then an invalid quantity message shown

