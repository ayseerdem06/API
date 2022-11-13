package practice;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C01_automationexercise extends AutomationBaseUrl {
     /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void test01() {
        // Set the url
        spec.pathParam("first","brandsList");

        //Send the Request and Get the response
        Response response=given().contentType(ContentType.JSON).spec(spec).when().get("/{first}");
        response.prettyPrint();

        assertEquals(200,response.getStatusCode());
        assertEquals("text/html; charset=utf-8",response.getContentType());
        assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

        List<String>brands=response.htmlPath().getList("brands.brand");

        int polo=0;
        int HM=0;

        for (int i = 0; i <brands.size() ; i++) {
            if(brands.get(i).equals("Polo")){
               polo++;
            } if(brands.get(i).equals("H&M")){
                HM++;
            }

        }
        assertEquals(polo,HM);



    }
}
