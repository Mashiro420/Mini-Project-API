package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.products.Products;

public class ProductsStep {

    @Steps
    Products products;

    @Given("I set an endpoint for GET All Products")
    public void iSetAnEndpointForGETAllProducts() {
        products.setAnEndpointForGet();
    }

    @When("I request GET All Products")
    public void iRequestGETAllProducts() {
        products.requestGetAllProducts();
    }

    @Then("I validate the GET All Products status code is {int}")
    public void iValidateTheGetAllProductsStatusCodeIs(int code) {
        products.validateGetAllProductsStatusCode(code);
    }

    @Given("I set an endpoint for GET Product By ID Positive")
    public void iSetAnEndpointForGETProductByIDPositive() {
        products.setAnEndpointForGetProductByIDPositive();
    }

    @When("I request GET Product By ID Positive")
    public void iRequestGETProductByIDPositive() {
        products.requestGetProductByIDPositive();
    }

    @Then("I validate the GET Product By ID Positive status code is {int}")
    public void iValidateTheGETProductByIDPositiveStatusCodeIs(int code) {
        products.validateGETProductByIDPositiveStatusCode(code);
    }

    @Given("I set an endpoint for GET Product By ID Negative")
    public void iSetAnEndpointForGETProductByIDNegative() {
        products.setAnEndpointForGetProductByIDNegative();
    }

    @When("I request GET Product By ID Negative")
    public void iRequestGETProductByIDNegative() {
        products.requestGetProductByIDNegative();
    }

    @Then("I validate the GET Product By ID Negative status code is {int}")
    public void iValidateTheGETProductByIDNegativeStatusCodeIs(int code) {
        products.validateGETProductByIDNegativeStatusCode(code);
    }

    @Given("I set an endpoint for POST Create Product Positive")
    public void iSetAnEndpointForPOSTCreateProductPositive() {
        products.setEndpointForCreateProduct();
    }

    @When("I request POST Create Product Positive")
    public void iRequestPOSTCreateProductPositive() {
        products.requestPostCreateProductPositive();
    }

    @Then("I validate the POST Create Product Positive status code is {int}")
    public void iValidateThePOSTCreateProductPositiveStatusCodeIs(int code) {
        products.validateStatusCodePositive(code);
    }

    @Given("I set an endpoint for POST Create Product Negative")
    public void iSetAnEndpointForPOSTCreateProductNegative() {
        products.setEndpointForCreateProduct();
    }

    @When("I request POST Create Product Negative")
    public void iRequestPOSTCreateProductNegative() {
        products.requestPostCreateProductNegative();
    }

    @Then("I validate the POST Create Product Negative status code is {int}")
    public void iValidateThePOSTCreateProductNegativeStatusCodeIs(int code) {
        products.validateStatusCodeNegative(code);
    }
}
