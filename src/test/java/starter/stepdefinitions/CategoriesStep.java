package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.categories.Categories;

public class CategoriesStep {

    @Steps
    Categories categories;

    @Given("I set an endpoint for GET All Categories")
    public void iSetAnEndpointForGETAllCategories() {
        categories.setAnEndpointForGet();
    }

    @When("I request GET All Categories")
    public void iRequestGETAllCategories() {
        categories.requestGetAllCategories();
    }

    @Then("I validate the GET All Categories status code is {int}")
    public void iValidateTheGETAllCategoriesStatusCodeIs(int code) {
        categories.validateGetAllCategoriesStatusCode(code);
    }

    @Given("I set an endpoint for POST Create Categories Positive")
    public void iSetAnEndpointForPOSTCreateCategoriesPositive() {
        categories.setEndpointForCreateCategories();
    }

    @When("I request POST Create Categories Positive")
    public void iRequestPOSTCreateCategoriesPositive() {
        categories.requestPostCreateProductPositive();
    }

    @Then("I validate the POST Create Categories Positive status code is {int}")
    public void iValidateThePOSTCreateCategoriesPositiveStatusCodeIs(int code) {
        categories.validateStatusCodePositive(code);
    }

    @Given("I set an endpoint for POST Create Categories Negative")
    public void iSetAnEndpointForPOSTCreateCategoriesNegative() {
        categories.setEndpointForCreateCategories();
    }

    @When("I request POST Create Categories Negative")
    public void iRequestPOSTCreateCategoriesNegative() {
        categories.requestPostCreateProductNegative();
    }

    @Then("I validate the POST Create Categories Negative status code is {int}")
    public void iValidateThePOSTCreateCategoriesNegativeStatusCodeIs(int code) {
        categories.validateStatusCodeNegative(code);
    }
}
