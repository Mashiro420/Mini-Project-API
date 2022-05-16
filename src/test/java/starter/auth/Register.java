package starter.auth;

import Utils.GeneralEmail;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Register {

    GeneralEmail generalEmail = new GeneralEmail();
    String email;

    private static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for POST register")
    public String setPostEndpointRegister(){
        return base_url + "auth/register";
    }

    @Step("I request POST register")
    public String getEmail(){
        return this.email;
    }

    @Step("I request POST register")
    public void requestPostRegister(String fullname, String email, String password){
        JSONObject requestData = new JSONObject();
        if (email.equals("new")){
            this.email = generalEmail.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (email.equals("same")){
            this.email = "test";
        }

        requestData.put("fullname", fullname);
        requestData.put("email", this.email);
        requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(setPostEndpointRegister());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
