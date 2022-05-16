package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.ratings.Ratings;

public class RatingsStep {

    @Steps
    Ratings ratings;

    @Given("I set an endpoint for Product’s Ratings")
    public void iSetAnEndpointForProductSRatings() {
        ratings.setAnEndpointForGet();
    }

    @When("I request GET Product’s Ratings")
    public void iRequestGETProductSRatings() {
        ratings.requestGetAllProducts();
    }

    @Then("I validate the Product’s Ratings status code is {int}")
    public void iValidateTheProductSRatingsStatusCodeIs(int code) {
        ratings.validateTheProductSRatingsStatusCode(code);
    }

    @Given("I set an endpoint for POST Ratings to a Product Positive")
    public void iSetAnEndpointForPOSTRatingsToAProductPositive() {
        ratings.setEndpointForPOSTRatingsToAProduct();
    }

    @When("I request POST Ratings to a Product Positive")
    public void iRequestPOSTRatingsToAProductPositive() throws Exception {
        ratings.requestPostRatingsToAProductPositive();
    }

    @Then("I validate the POST Ratings to a Product Positive status code is {int}")
    public void iValidateThePOSTRatingsToAProductPositiveStatusCodeIs(int code) {
        ratings.validateStatusCodePositive(code);
    }

    @Given("I set an endpoint for POST Ratings to a Product Negative")
    public void iSetAnEndpointForPOSTRatingsToAProductNegative() {
        ratings.setEndpointForPOSTRatingsToAProduct();
    }

    @When("I request POST Ratings to a Product Negative")
    public void iRequestPOSTRatingsToAProductNegative() throws Exception {
        ratings.requestPostRatingsToAProductNegative();
    }

    @Then("I validate the POST Ratings to a Product Negative status code is {int}")
    public void iValidateThePOSTRatingsToAProductNegativeStatusCodeIs(int code) {
        ratings.validateStatusCodeNegative(code);
    }
}
