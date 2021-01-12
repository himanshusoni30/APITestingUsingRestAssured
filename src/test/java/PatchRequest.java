import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PatchRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000";//"http://httpbin.org"
//        System.out.println("******** Adding new person into people list. ********");
        Response resp = given().contentType("application/json").
                body("{\"name\": \"Ivar The Boneless\"}").when().put("/people/101");

        System.out.println("Response: "+resp.asString());
        System.out.println("Status Code: "+resp.statusCode());
    }
}
