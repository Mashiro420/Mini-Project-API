package starter.ratings;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Ratings {

    private String token;

    protected static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for Product’s Ratings")
    public String setAnEndpointForGet(){
        return base_url + "products/1619/ratings";
    }

    @Step("I request GET Product’s Ratings")
    public void requestGetAllProducts(){
        given().when().get(setAnEndpointForGet());
    }

    @Step("I validate the Product’s Ratings status code is {int}")
    public void validateTheProductSRatingsStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    @Step("I set an endpoint for POST Ratings to a Product")
    public String setEndpointForPOSTRatingsToAProduct(){
        return base_url + "products/1619/ratings";
    }

    @Step("I request POST Ratings to a Product Positive")
    public void requestPostRatingsToAProductPositive() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataPositive())
                .when().post(setEndpointForPOSTRatingsToAProduct());
    }

    @Step("Build request data positive")
    public JSONObject bodyDataPositive(){
        JSONObject body = new JSONObject();

        body.put("count", 5);
        return body;
    }

    @Step("I validate the POST Ratings to a Product Positive status code is {int}")
    public void validateStatusCodePositive(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I request POST Ratings to a Product Negative")
    public void requestPostRatingsToAProductNegative() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataNegative())
                .when().post(setEndpointForPOSTRatingsToAProduct());
    }

    @Step("Build request data negative")
    public JSONObject bodyDataNegative(){
        JSONObject body = new JSONObject();

        body.put("count", 6);
        return body;
    }

    @Step("I validate the POST Ratings to a Product Negative status code is {int}")
    public void validateStatusCodeNegative(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
