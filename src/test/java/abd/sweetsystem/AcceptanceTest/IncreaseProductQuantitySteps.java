package abd.sweetsystem.AcceptanceTest;

import abd.sweetsystem.clasess.OwnerAndSupplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

@Tag("tag2")
public class IncreaseProductQuantitySteps {
    public OwnerAndSupplier owner= new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
    public String errorMessage;

    @Given("a product have name {string} exists and belongs to the user and quantity of {int}")
    public void a_product_have_name_exists_and_belongs_to_the_user(String name, int quantity) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
        owner.addNewProduct(name, "Description", 10.0, quantity);
    }

    @When("the user increases the product {string} quantity by {int}")
    public void the_user_increases_the_product_quantity_by(String name, int quantity) {
        errorMessage = owner.increaseProductQuantity(name, quantity);
    }

    @Then("successful operation message should be shown")
    public void successful_operation_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.SUCCESSFUL_OPERATION, errorMessage);
    }

    @Given("a product have name {string} does not exist")
    public void a_product_have_name_does_not_exist(String name) {
        owner = new OwnerAndSupplier(name, "owner@example.com", "password", "Owner", "Location");
    }

    @When("the user tries to increase the product {string} quantity by {int}")
    public void the_user_tries_to_increase_the_product_quantity_by(String name, int quantity) {
        errorMessage = owner.increaseProductQuantity(name, quantity);
    }

    @Then("an invalid name message shown")
    public void an_invalid_name_message_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_NAME_MESSAGE, errorMessage);
    }

    @Then("an invalid permission message shown")
    public void an_invalid_permission_message_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_PERMISSION_MESSAGE, errorMessage);
    }

    @Given("a product have name {string} exists but does not belong to the user")
    public void a_product_have_name_exists_but_does_not_belong_to_the_user(String name) {
        owner = new OwnerAndSupplier(name, "owner@example.com", "password", "Owner", "Location");
    }

    @Then("an invalid quantity message shown")
    public void an_invalid_quantity_message_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_QUANTITY_MESSAGE, errorMessage);
    }
}
