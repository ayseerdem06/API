package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01b {

       /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    // Set the URL
    // Set The Expected Data ( put,post,patch)
    // Send The Request And Get The Response
    // Do Assertion

    @Test
    public void get01() {
        // Set the URL
        String url="https://reqres.in/api/users/3";

        // Set The Expected Data ( put,post,patch)

        // Send The Request And Get The Response (Talep gonder ve cevap al)
        Response response=given().when().get(url);
        response.prettyPrint();


        // Do Assertion
        //  HTTP Status Code should be 200
        // Content Type should be JSON
        // Status Line should be HTTP/1.1 200 OK
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");





    }
}
