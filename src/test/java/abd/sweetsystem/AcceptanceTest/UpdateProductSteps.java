package abd.sweetsystem.AcceptanceTest;


import abd.sweetsystem.clasess.OwnerAndSupplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

@Tag("tag2")
public class UpdateProductSteps {

    public OwnerAndSupplier owner;
    public String errorMessage;

    @Given("a product has name {string} exists and belongs to the user")
    public void a_product_has_name_exists_and_belongs_to_the_user(String productName) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
        owner.addNewProduct(productName, "Updated description", 100.00, 10);
    }

    @When("the user updates the product with name {string}, description {string}, price {double}, and quantity {int}")
    public void the_user_updates_the_product_with_name_description_price_and_quantity(String name, String description, Double price, Integer quantity) {
        errorMessage = owner.updateProduct(name, description, price, quantity);
    }

    @Then("a successful operation message should be shown")
    public void a_successful_operation_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.SUCCESSFUL_OPERATION, errorMessage);
    }

    @Then("invalid price message should be shown")
    public void invalid_price_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_PRICE_MESSAGE, errorMessage);
    }

    @Then("invalid quantity message should be shown")
    public void invalid_quantity_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_QUANTITY_MESSAGE, errorMessage);
    }

    @Given("a product has name {string} exists but does not belong to the user")
    public void a_product_has_name_exists_but_does_not_belong_to_the_user(String name) {
        owner = new OwnerAndSupplier(name, "owner@example.com", "password", "Owner", "Location");
    }

    @When("the user tries to update the product with name {string}, description {string}, price {double}, and quantity {int}")
    public void the_user_tries_to_update_the_product_with_name_description_price_and_quantity(String name, String description, double price, int quantity) {
        errorMessage = owner.updateProduct(name, description, price, quantity);
    }

    @Then("invalid permission message should be shown")
    public void invalid_permission_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_PERMISSION_MESSAGE, errorMessage);
    }

    @Given("a product has name {string} does not exist")
    public void a_product_has_name_does_not_exist(String name) {
        owner = new OwnerAndSupplier(name, "owner@example.com", "password", "Owner", "Location");
    }

    @Then("invalid name message should be shown")
    public void invalid_name_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_NAME_MESSAGE, errorMessage);
    }
}
