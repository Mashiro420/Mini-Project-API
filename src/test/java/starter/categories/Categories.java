package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Categories {

    protected static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for GET All Categories")
    public String setAnEndpointForGet(){
        return base_url + "categories";
    }

    @Step("I set an endpoint for POST Create Categories")
    public String setEndpointForCreateCategories(){
        return base_url + "categories";
    }

    @Step("I request POST Create Product Positive")
    public void requestPostCreateProductPositive() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyDataPositive())
                .when().post(setEndpointForCreateCategories());
    }

    @Step("Build request data positive")
    public JSONObject bodyDataPositive(){
        JSONObject body = new JSONObject();

        body.put("name", "Gadget");
        return body;
    }

    @Step("I request POST Create Product Negative")
    public void requestPostCreateProductNegative() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyDataNegative())
                .when().post(setEndpointForCreateCategories());
    }

    @Step("Build request data negative")
    public JSONObject bodyDataNegative(){
        JSONObject body = new JSONObject();

        body.put("nama", "Gadget");
        return body;
    }

    @Step("I validate the POST Create Categories Positive status code is {int}")
    public void validateStatusCodePositive(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I validate the POST Create Categories Negative status code is {int}")
    public void validateStatusCodeNegative(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I request GET All Categories")
    public void requestGetAllCategories(){
        given().when().get(setAnEndpointForGet());
    }

    @Step("I validate the GET All Categories status code is {int}")
    public void validateGetAllCategoriesStatusCode(int code){
        then().statusCode(equalTo(code));
    }

}
