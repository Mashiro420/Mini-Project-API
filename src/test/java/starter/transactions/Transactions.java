package starter.transactions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Transactions {

    private String token;

    protected static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for GET All Transactions")
    public String setAnEndpointForGet(){
        return base_url + "orders";
    }

    @Step("I request GET All Transactions")
    public void requestGetAllTransactions() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(setAnEndpointForGet());
    }

    @Step("I validate the GET All Transactions status code is {int}")
    public void validateGetAllTransactionsStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    @Step("I set an endpoint for POST Create Transactions")
    public String setEndpointForCreateTransactions(){
        return base_url + "orders";
    }

    @Step("I request POST Create Transactions Positive")
    public void requestPostCreateTransactionsPositive() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataPositive())
                .when().post(setEndpointForCreateTransactions());
    }

    @Step("Build request data positive")
    public List<JSONObject> bodyDataPositive(){
        List<JSONObject> body = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id", 1);
        data.put("quantity", 2);

        body.add(data);
        return body;
    }

    @Step("I validate the POST Create Transactions Positive status code is {int}")
    public void validateStatusCodePositive(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I request POST Create Transactions Negative")
    public void requestPostCreateTransactionsNegative() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataNegative())
                .when().post(setEndpointForCreateTransactions());
    }

    @Step("Build request data negative")
    public List<JSONObject> bodyDataNegative(){
        List<JSONObject> body = new ArrayList<>();

        JSONObject data = new JSONObject();
        data.put("product_id", "a");
        data.put("quantity", 2);

        body.add(data);
        return body;
    }

    @Step("I validate the POST Create Transactions Negative status code is {int}")
    public void validateStatusCodeNegative(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
