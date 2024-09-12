package abd.sweetsystem.AcceptanceTest;

import abd.sweetsystem.clasess.Product;
import abd.sweetsystem.clasess.StoreOwner;
import abd.sweetsystem.clasess.Supplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

@Tag("tag2")
public class RequestOrderSteps {
    Supplier supplier;
    StoreOwner owner;
    StoreOwner supplierOwner;
    Product product;
    String errorMessage;

    @Given("I have a supplier with name {string} and a product with name {string}")
    public void i_have_a_supplier_with_id_and_a_product_with_name(String suppName, String name) {
        supplier = new Supplier(suppName, "email", "pass", "supplier", "location", "111");
        product = new Product("1231231231231", name, "wow prod", 100, 10, suppName);
        owner = new StoreOwner("owner1", "email", "Owner", "pass", "location", "123");
    }

    @When("owner request an order of {int} units from supplier")
    public void owner_request_an_order_of_units_for_product_from_supplier(int units) {
        errorMessage = owner.requestOrder(product.getName(), supplier.getName(), units);
    }

    @Then("successful message shown")
    public void successful_message_shown() {
        Assert.assertEquals(StoreOwner.SUCCESSFUL_OPERATION, errorMessage);
    }

    @When("owner request an order of {int} units from a supplier {string}")
    public void owner_request_an_order_of_units_for_product_from_a_supplier(int units, String suppName) {
        errorMessage = owner.requestOrder(product.getName(), suppName, units);
    }

    @Then("the system should show not an instance message")
    public void the_system_should_show_not_an_instance_message() {
        Assert.assertEquals(StoreOwner.NOT_AN_INSTANCE_MESSAGE, errorMessage);
    }

    @Given("I have a owner with name {string} and a product with name {string}")
    public void i_have_a_owner_with_id_and_a_product_with_id(String ownerName, String name) {
        supplierOwner = new StoreOwner(ownerName, "email", "pass", "supplier", "location", "12");
        product = new Product("123", name, "wow prod", 100, 10, ownerName);
        owner = new StoreOwner("owner", "email", "Owner", "pass", "location", "123");
    }

    @When("I request an order of {int} units from owner {string}")
    public void i_request_an_order_of_units_for_product_from_owner(int units, String ownerName) {
        errorMessage = owner.requestOrder(product.getName(), ownerName, units);
    }

    @Then("the system should show invalid quantity message")
    public void the_system_should_show_invalid_quantity_message() {
        Assert.assertEquals(StoreOwner.INVALID_QUANTITY_MESSAGE, errorMessage);
    }
}
