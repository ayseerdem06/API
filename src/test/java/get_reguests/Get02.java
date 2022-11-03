package get_reguests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

   /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
  */

    @Test
    public void get01() {
        //  i)Set the URL,
        String url="https://restful-booker.herokuapp.com/booking/1";

        //  ii)Set the expected Data (beklenen datanın olusturulmasi, bunlari Post, Put, Patch ile yapacagiz)
        // iii)Type code to send request (Talep göndermek icin kod yazimi)
        Response response=given().when().get(url);
        response.prettyPrint();

        // iv) Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Bady Not Found iceriyormu testi yapılıyor.
        assertTrue(response.asString().contains("Not Found"));

        // Bady'nin  TechProEd icermiyor mu testi yapılıyor.
        assertFalse(response.asString().contains("TechProEd"));;

        //Server'in Cowboy olup olmadigini test ediyoryz.
        assertEquals("Cowboy",response.getHeader("Server"));

    }
}
