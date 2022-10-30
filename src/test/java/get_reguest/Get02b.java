package get_reguest;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseUrl {
    
      /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void get02() {

        // Set the URL
        spec.pathParams("first","users","second",23);

        // Set The Expected Data ( put,post,patch)

        // Send The Request And Get The Response (Talep gonder ve cevap al)
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        // Status Line should be HTTP/1.1 404 Not Found
        // Server is "cloudflare"
        // Response body should be empty

        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.header("Server"));
        //assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());    ilk yöntem ile tum sayı ve harfler dışındakiler silerek uzunluk 0 lanır
        assertEquals(2,response.asString().replaceAll("\\s","").length());   // boşluklar space ler silinir sadece süslü parantez kalır ve uzunluk 2 olur bu şekilde de sorgulanabilir




    }
}
