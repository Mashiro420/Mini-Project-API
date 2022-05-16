package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.comments.Comments;

public class CommentStep {

    @Steps
    Comments comments;

    @Given("I set an endpoint for GET Product’s Comments")
    public void iSetAnEndpointForGETProductSComments() {
        comments.setAnEndpointForGet();
    }

    @When("I request GET Product’s Comments")
    public void iRequestGETProductSComments() {
        comments.requestGetProductSComments();
    }

    @Then("I validate GET Product’s Comments status code is {int}")
    public void iValidateGETProductSCommentsStatusCodeIs(int code) {
        comments.validateGETProductSCommentsStatusCode(code);
    }

    @Given("I set an endpoint for POST Comment to a Product Positive")
    public void iSetAnEndpointForPOSTCommentToAProductPositive() {
        comments.setEndpointForPOSTCommentToAProduct();
    }

    @When("I request POST Comment to a Product Positive")
    public void iRequestPOSTCommentToAProductPositive() throws Exception {
        comments.requestPostCommentToAProductPositive();
    }

    @Then("I validate the POST Comment to a Product Positive status code is {int}")
    public void iValidateThePOSTCommentToAProductPositiveStatusCodeIs(int code) {
        comments.validateStatusCodePositive(code);
    }

    @Given("I set an endpoint for POST Comment to a Product Negative")
    public void iSetAnEndpointForPOSTCommentToAProductNegative() {
        comments.setEndpointForPOSTCommentToAProduct();
    }

    @When("I request POST Comment to a Product Negative")
    public void iRequestPOSTCommentToAProductNegative() throws Exception {
        comments.requestPostCommentToAProductNegative();
    }

    @Then("I validate the POST Comment to a Product Negative status code is {int}")
    public void iValidateThePOSTCommentToAProductNegativeStatusCodeIs(int code) {
        comments.validateStatusCodeNegative(code);
    }
}
