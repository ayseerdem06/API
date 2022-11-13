package practice;

import base_urls.ReqresBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04_reqresMap_patch extends ReqresBaseUrl {

    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.


  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void test04() {
        // Map ile
        // Set the url
        spec.pathParams("first","users","second",2);

        //Set the Expected Data
        Map<String,String>expectedData=new HashMap<>();
        expectedData.put("name","neo");
        System.out.println("expectedData = " + expectedData);

        // Set Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Gson gson=new Gson();
        HashMap actualData = gson.fromJson(response.asString(),(HashMap.class));
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));



    }


}
