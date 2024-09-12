@tag2
Feature: Delete a product by name
  As a store owner or supplier,
  I want to delete my product by name
  So that I can remove outdated or unwanted products from my catalog

  Scenario: Successfully delete a product
    Given a product with name "Product1" exists and belongs to the user
    When the user deletes the product with name "Product1"
    Then the product should be removed from the user's catalog

  Scenario: Fail to delete a product that does not exist
    Given a product with name "NonExistentProduct" does not exist
    When the user tries to delete the product with name "NonExistentProduct"
    Then an invalid name message should be shown

  Scenario: Fail to delete a product that does not belong to the user
    Given a product with name "Product2" exists but does not belong to the user
    When the user tries to delete the product with name "Product2"
    Then an invalid permission message should be shown
