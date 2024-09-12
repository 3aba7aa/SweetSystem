@tag2
Feature: Add a new product to the inventory

  As a store Owner or Supplier,
  I want to add new products to the inventory
  So that they are available for sale

  Scenario: Successfully adding a new product
    Given I have an empty inventory
    When I add a new product with the name "Cookie", description "Chocolate cookie", price 3, and quantity 20
    Then the product "Cookie" should be in the inventory
    And the inventory should contain 1 product
    And the product "Cookie" should have a quantity of 20
    And successful operation message be shown

  Scenario: Adding a product with a negative price
    Given I have an empty inventory
    When I add a new product with the name "Cookie", description "Chocolate cookie", price -5, and quantity 5
    Then the product should not be added to the inventory
    And an invalid price message should be shown

  Scenario: Adding a product with a negative quantity
    Given I have an empty inventory
    When I add a new product with the name "Cookie", description "Chocolate cookie", price 5, and quantity -5
    Then an invalid quantity message should be shown

  Scenario: Adding a duplicate product
    Given I have an inventory with a product "Cookie" with description "Chocolate cookie", price 3, and quantity 5
    When I add a new product with the same name "Cookie", description "Chocolate cookie", price 3, and quantity 5
    Then the quantity for product with name "Cookie" should be increased by the new quantity
    And successful operation message be shown