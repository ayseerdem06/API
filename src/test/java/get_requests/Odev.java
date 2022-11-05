package get_requests;

import base_url.AutomationBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev extends AutomationBaseUrl {

    /*
    Given
    https://automationexercise.com/api/productsList
    When
    User sends a GET Request to the url
    Then
    HTTP Status Code should be 200
    And
    Content Type should be "text/html; charset=utf-8"
    And
    Status Line should be HTTP/1.1 200 OK
    And
     There must be 12 Women, 9 Men, 13 Kids usertype in products

     Verilen https:automationexercise.comapiproductsList
      Kullanıcı url'ye GET İsteği gönderdiğinde
       HTTP Durum Kodu 200 ve
       İçerik Tipi "texthtml; charset=utf-8"
       ve Durum Satırı HTTP1.1 200 Tamam Ve Olmalıdır
        Ürünlerde 12 Kadın, 9 Erkek, 13 Çocuk kullanıcı tipi
  */
    // Set the URL
    // Set The Expected Data ( put,post,patch)
    // Send The Request And Get The Response
    // Do Assertion


    @Test
    public void test01() {
        // Set the URL
        spec.pathParam("first","productsList");

        // Set The Expected Data ( put,post,patch)
        // Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");

        // Do Assertion
        assertEquals(200,response.getStatusCode());
        assertEquals("text/html; charset=utf-8",response.getContentType());
        assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        JsonPath jsonPath=response.jsonPath();
        jsonPath.prettyPrint();
       // List<Integer> women=jsonPath.getList("products.category.usertype.findAll{it.usertype=Women}.id");
      //  System.out.println(women);




    }
}
