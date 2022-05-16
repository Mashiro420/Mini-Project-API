package starter.products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class Products {

    protected static String base_url = "https://be-qa.alta.id/api/";

    @Step("I set an endpoint for GET All Products")
    public String setAnEndpointForGet(){
        return base_url + "products";
    }

    @Step("I request GET All Products")
    public void requestGetAllProducts(){
        given().when().get(setAnEndpointForGet());
    }

    @Step("I validate the GET All Products status code is {int}")
    public void validateGetAllProductsStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    @Step("I set an endpoint for GET Product By ID Positive")
    public String setAnEndpointForGetProductByIDPositive(){
        return base_url + "products/1584";
    }

    @Step("I set an endpoint for GET Product By ID Negative")
    public String setAnEndpointForGetProductByIDNegative(){
        return base_url + "products/1";
    }

    @Step("I set an endpoint for POST Create Product")
    public String setEndpointForCreateProduct(){
        return base_url + "products";
    }

    @Step("I request POST Create Product Positive")
    public void requestPostCreateProductPositive() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyDataPositive())
                .when().post(setEndpointForCreateProduct());
    }

    @Step("Build request data positive")
    public JSONObject bodyDataPositive(){
        JSONObject body = new JSONObject();
        List<Integer> data = new ArrayList<>();

        body.put("name", "Laptop");
        body.put("price", 20400000);

        data.add(3);
        data.add(6);

        body.put("categories", data);
        return body;
    }

    @Step("I request POST Create Product Negative")
    public void requestPostCreateProductNegative() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(bodyDataNegative())
                .when().post(setEndpointForCreateProduct());
    }

    @Step("Build request data negative")
    public JSONObject bodyDataNegative(){
        JSONObject body = new JSONObject();
        List<Integer> data = new ArrayList<>();

        body.put("name", "Laptop");
        body.put("price", "dua puluh juta empat ratus ribu");

        data.add(3);
        data.add(6);

        body.put("categories", data);
        return body;
    }

    @Step("I validate the POST Create Product Positive status code is {int}")
    public void validateStatusCodePositive(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step("I validate the POST Create Product Negative status code is {int}")
    public void validateStatusCodeNegative(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Step()
    public void requestGetProductByIDPositive(){
        given().when().get(setAnEndpointForGetProductByIDPositive());
    }

    @Step()
    public void requestGetProductByIDNegative(){
        given().when().get(setAnEndpointForGetProductByIDNegative());
    }

    @Step("I validate the GET Product By ID Positive status code is {int}")
    public void validateGETProductByIDPositiveStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    @Step("I validate the GET Product By ID Negative status code is {int}")
    public void validateGETProductByIDNegativeStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
