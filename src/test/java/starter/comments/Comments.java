package starter.comments;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Comments {

    private String token;

    protected static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for GET Product’s Comments")
    public String setAnEndpointForGet(){
        return base_url + "products/1619/comments";
    }

    @Step("I request GET Product’s Comments")
    public void requestGetProductSComments(){
        given().when().get(setAnEndpointForGet());
    }

    @Step("I validate GET Product’s Comments status code is {int}")
    public void validateGETProductSCommentsStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    @Step("I set an endpoint for POST Comment to a Product")
    public String setEndpointForPOSTCommentToAProduct(){
        return base_url + "products/1619/comments";
    }

    @Step("I request POST Comment to a Product Positive")
    public void requestPostCommentToAProductPositive() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataPositive())
                .when().post(setEndpointForPOSTCommentToAProduct());
    }

    @Step("Build request data positive")
    public JSONObject bodyDataPositive(){
        JSONObject body = new JSONObject();

        body.put("content", "Laptop Gaming");
        return body;
    }

    @Step("I validate the POST Ratings to a Product Positive status code is {int}")
    public void validateStatusCodePositive(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I request POST Comment to a Product Negative")
    public void requestPostCommentToAProductNegative() throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//newToken.json"), StandardCharsets.UTF_8);
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(bodyDataNegative())
                .when().post(setEndpointForPOSTCommentToAProduct());
    }

    @Step("Build request data negative")
    public JSONObject bodyDataNegative(){
        JSONObject body = new JSONObject();

        body.put("content", 5);
        return body;
    }

    @Step("I validate the POST Ratings to a Product Negative status code is {int}")
    public void validateStatusCodeNegative(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
}
