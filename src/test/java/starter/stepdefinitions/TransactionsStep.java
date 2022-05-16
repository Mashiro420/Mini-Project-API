package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transactions.Transactions;

public class TransactionsStep {

    @Steps
    Transactions transactions;

    @Given("I set an endpoint for GET All Transactions")
    public void iSetAnEndpointForGETAllTransactions() {
        transactions.setAnEndpointForGet();
    }

    @When("I request GET All Transactions")
    public void iRequestGETAllTransactions() throws Exception {
        transactions.requestGetAllTransactions();
    }

    @Then("I validate the GET All Transactions status code is {int}")
    public void iValidateTheGETAllTransactionsStatusCodeIs(int code) {
        transactions.validateGetAllTransactionsStatusCode(code);
    }

    @Given("I set an endpoint for POST Create Transactions Positive")
    public void iSetAnEndpointForPOSTCreateTransactionsPositive() {
        transactions.setEndpointForCreateTransactions();
    }

    @When("I request POST Create Transactions Positive")
    public void iRequestPOSTCreateTransactionsPositive() throws Exception {
        transactions.requestPostCreateTransactionsPositive();
    }

    @Then("I validate the POST Create Transactions Positive status code is {int}")
    public void iValidateThePOSTCreateTransactionsPositiveStatusCodeIs(int code) {
        transactions.validateStatusCodePositive(code);
    }

    @Given("I set an endpoint for POST Create Transactions Negative")
    public void iSetAnEndpointForPOSTCreateTransactionsNegative() {
        transactions.setEndpointForCreateTransactions();
    }

    @When("I request POST Create Transactions Negative")
    public void iRequestPOSTCreateTransactionsNegative() throws Exception {
        transactions.requestPostCreateTransactionsNegative();
    }

    @Then("I validate the POST Create Transactions Negative status code is {int}")
    public void iValidateThePOSTCreateTransactionsNegativeStatusCodeIs(int code) {
        transactions.validateStatusCodeNegative(code);
    }
}
