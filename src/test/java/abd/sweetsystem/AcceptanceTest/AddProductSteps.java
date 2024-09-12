package abd.sweetsystem.AcceptanceTest;

import abd.sweetsystem.clasess.OwnerAndSupplier;
import abd.sweetsystem.clasess.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

import static org.junit.Assert.*;

@Tag("tag2")
public class AddProductSteps {

    private OwnerAndSupplier owner;
    private String errorMessage;
    private int oldQuantity;
    private int newQuantity;

    @Given("I have an empty inventory")
    public void i_have_an_empty_inventory() {
        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
        assertTrue(owner.getProducts().isEmpty());
    }

    @When("I add a new product with the name {string}, description {string}, price {int}, and quantity {int}")
    public void i_add_a_new_product_with_the_name_description_price_and_quantity(String name, String description, double price, int quantity) {
            errorMessage = owner.addNewProduct(name, description, price, quantity);
    }

    @Then("the product {string} should be in the inventory")
    public void the_product_should_be_in_the_inventory(String name) {
        Product product = Product.getProduct(name);
        assertTrue(owner.getProducts().contains(product));
    }

    @Then("the inventory should contain {int} product")
    public void the_inventory_should_contain_product(int count) {
        assertEquals(count, owner.getProducts().size());
    }

    @Then("the product {string} should have a quantity of {int}")
    public void the_product_should_have_a_quantity_of(String name, int quantity) {
        Product product = Product.getProduct(name);
        assertNotNull(product);
        assertEquals(quantity, product.getQuantity());
    }

    @Then("the product should not be added to the inventory")
    public void the_product_should_not_be_added_to_the_inventory() {
        assertTrue(owner.getProducts().isEmpty());
    }

    @Then("an invalid price message should be shown")
    public void an_invalid_price_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_PRICE_MESSAGE, errorMessage);
    }

    @Given("I have an inventory with a product {string} with description {string}, price {int}, and quantity {int}")
    public void i_have_an_inventory_with_a_product_with_description_price_and_quantity(String name, String description, Integer price, Integer quantity) {

        owner = new OwnerAndSupplier("Owner Name", "owner@example.com", "password", "owner", "location");
        owner.addNewProduct(name, description, price, quantity);
    }

    @When("I add a new product with the same name {string}, description {string}, price {int}, and quantity {int}")
    public void i_add_a_new_product_with_the_same_name_description_price_and_quantity(String name, String description, Integer price, Integer quantity) {
        Product product = Product.getProduct(name);
        if(product != null) {
            oldQuantity = product.getQuantity();
            newQuantity = quantity;
            errorMessage = owner.addNewProduct(name, description, price, quantity);
        }
        else {
            errorMessage = "The product does not exist";
        }
    }

    @Then("the quantity for product with name {string} should be increased by the new quantity")
    public void the_quantity_for_product_with_name_should_be_increased_by_the_new_quantity(String name) {
        assertEquals(oldQuantity + newQuantity, Product.getProduct(name).getQuantity());
    }

    @Then("an invalid quantity message should be shown")
    public void an_invalid_quantity_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_QUANTITY_MESSAGE, errorMessage);
    }

    @And("successful operation message be shown")
    public void successful_operation_message_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.SUCCESSFUL_OPERATION, errorMessage);
    }

}

