import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PutRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000";//"http://httpbin.org"
        System.out.println("******** Adding new person into people list. ********");
        Response resp = given().contentType("application/json").body("{\n" +
                "  \"name\": \"Bjorn Ironside\",\n" +
                "  \"phone\": \"(840) 568-2855\",\n" +
                "  \"email\": \"bjornironside@yahoo.com\",\n" +
                "  \"address\": [{\n" +
                "    \"zipCode\": \"54927-0000\",\n" +
                "    \"city\": \"Scandinavia\"\n" +
                "  }]\n" +
                "}").when().put("/people/101");

        System.out.println("Response: "+resp.asString());
        System.out.println("Status Code: "+resp.statusCode());
    }
}
