import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test
    void test1(){
       Response randomResponseName = get("https://reqres.in/api/users?page=2");

        System.out.println("Response: " + randomResponseName.asString());
        System.out.println("Status Code: " + randomResponseName.getStatusCode());
        System.out.println("Body: " + randomResponseName.getBody().asString());
        System.out.println("Time taken: " + randomResponseName.getTime());
        System.out.println("Header: " + randomResponseName.getHeader("content-type"));

        int statusCode = randomResponseName.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }
}
