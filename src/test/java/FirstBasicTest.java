import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class FirstBasicTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://httpbin.org";

        when().get("/get").then().assertThat().statusCode(200);
    }
}
