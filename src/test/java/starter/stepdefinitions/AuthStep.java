package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.auth.Login;
import starter.auth.Register;

public class AuthStep {

    public String email;

    @Steps
    Register register;

    @Steps
    Login login;

    @Given("I set an endpoint for POST new {string} with {string} and {string}")
    public void iSetAnEndpointForPOSTNewWithAnd(String fullname, String email, String password) {
        register.requestPostRegister(fullname, email, password);
    }

    @When("I request POST register")
    public void iRequestPOSTRegister() {
        this.email = register.getEmail();
    }

    @Then("I validate register status code is {int}")
    public void iValidateRegisterStatusCodeIs(int code) {
        register.validateStatusCode(code);
    }

    @Given("I set an endpoint for POST {string} and {string}")
    public void iSetAnEndpointForPOSTAnd(String email, String password) {
        login.requestPostLogin(email, password);
    }

    @When("I request POST login")
    public void iRequestPOSTLogin() {
        this.email = login.getlogin();
    }

    @Then("I validate login status code is {int}")
    public void iValidateLoginStatusCodeIs(int code) {
        login.validateStatusCode(code);
    }

    @And("get token if {string} for other request")
    public void getTokenIfForOtherRequest(String message) {
        if (message.equals("success")){
            login.getToken();
        }
    }
}
