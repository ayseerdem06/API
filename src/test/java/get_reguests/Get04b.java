package get_reguests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get04b extends RestfulBaseUrl {

      /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
     */

    @Test
    public void test04() {
        // Set the URL
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");

        // Set The Expected Data ( put,post,patch)

        // Send The Request And Get The Response (Talep gonder ve cevap al)
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do Assertion
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
