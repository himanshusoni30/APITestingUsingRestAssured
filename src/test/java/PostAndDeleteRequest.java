import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostAndDeleteRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000";//"http://httpbin.org"
        System.out.println("******** Adding new person into people list. ********");
        Response resp = given().contentType("application/json").body("{\n" +
                "  \"name\": \"Rick Sanchez\",\n" +
                "  \"phone\": \"(840) 568-2855 x000\",\n" +
                "  \"email\": \"rick.sanchez@yahoo.com\",\n" +
                "  \"address\": [{\n" +
                "    \"city\": \"California\",\n" +
                "    \"zipCode\": \"54927\"\n" +
                "  }]\n" +
                "}").when().post("/people");

        System.out.println("Response: "+resp.asString());
        System.out.println("Status Code: "+resp.statusCode());
        resp.
                then().
                assertThat().
                statusCode(201).
                and().
                body("name",equalTo("Rick Sanchez")).
                and().
                body("id",equalTo(102));

        System.out.println("******** Delete new person from people list. ********");
        Response delResp = when().delete("people/102");
        System.out.println("Response: "+delResp.asString());
        System.out.println("Status Code: "+delResp.statusCode());
        delResp.then().assertThat().statusCode(200);
    }
}
