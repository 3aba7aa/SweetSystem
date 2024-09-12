package abd.sweetsystem.AcceptanceTest;

import abd.sweetsystem.clasess.OwnerAndSupplier;
import abd.sweetsystem.clasess.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;


@Tag("tag2")
public class DeleteProductSteps {
    public OwnerAndSupplier owner;
    public String deleteResult;


    @Given("a product with name {string} exists and belongs to the user")
    public void a_product_with_name_exists_and_belongs_to_the_user(String productName) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
        owner.addNewProduct(productName, "Description", 10.0, 5);
    }

    @When("the user deletes the product with name {string}")
    public void the_user_deletes_the_product_with_name(String productName) {
        try {
            owner.deleteProduct(productName);
        } catch (Exception e) {
            deleteResult = e.getMessage();
        }
    }

    @Then("the product should be removed from the user's catalog")
    public void the_product_should_be_removed_from_the_user_s_catalog() {
        Product product = Product.getProduct("Product1");
        Assert.assertNull(product);
    }

    @Given("a product with name {string} does not exist")
    public void a_product_with_name_does_not_exist(String string) {
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
    }

    @When("the user tries to delete the product with name {string}")
    public void the_user_tries_to_delete_the_product_with_name(String productName) {
        deleteResult = owner.deleteProduct(productName);
    }

    @Then("an invalid name message should be shown")
    public void an_invalid_name_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_NAME_MESSAGE, deleteResult);
    }

    @Given("a product with name {string} exists but does not belong to the user")
    public void a_product_with_name_exists_but_does_not_belong_to_the_user(String productName) {
        OwnerAndSupplier otherOwner = new OwnerAndSupplier("OtherOwner", "other@example.com", "password", "Owner", "Location");
        otherOwner.addNewProduct(productName, "Description", 10.0, 5);
        owner = new OwnerAndSupplier("Owner", "owner@example.com", "password", "Owner", "Location");
    }

    @Then("an invalid permission message should be shown")
    public void an_invalid_permission_message_should_be_shown() {
        Assert.assertEquals(OwnerAndSupplier.INVALID_PERMISSION_MESSAGE, deleteResult);
    }
}
