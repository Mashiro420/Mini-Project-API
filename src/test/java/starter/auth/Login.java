package starter.auth;

import Utils.GeneralEmail;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class Login {

    GeneralEmail generalEmail = new GeneralEmail();
    String email;

    private static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for POST login")
    public String setPostEndpointLogin(){
        return base_url + "auth/login";
    }

    @Step("I request POST login")
    public String getlogin(){
        return this.email;
    }

    @Step("I request POST login")
    public void requestPostLogin(String email, String password){
        JSONObject requestData = new JSONObject();
        if (email.equals("same")){
            this.email = "test";

        } else if (email.equals("new")){
            this.email = generalEmail.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        requestData.put("email", this.email);
        requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(setPostEndpointLogin());
    }

    @Step("I validate the status code is {int}")
    public void validateStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("get token from the response")
    public String getToken(){
        Response response = SerenityRest.lastResponse();
        String token = response.body().path("data");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//newToken.json")) {
            file.write(token);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(token);
        return token;
    }
}
