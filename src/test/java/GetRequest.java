import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.when;

public class GetRequest {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000";//"http://httpbin.org"
        Response resp = when().get("/people");
        System.out.println(resp.jsonPath().getJsonObject("[0].name").toString());
        System.out.println(resp.headers());
        resp.then().statusCode(200).and().assertThat().statusCode(200).and().body("[0].name",equalTo("Leslie Kunze"));
    }
}
