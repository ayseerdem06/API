package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C02_reqresMap_post extends ReqresBaseUrl {

    /*
   2:  Map ve Pojo Class ile ayrı ayrı yapınız.

        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void test02() {

        // Map ile
        //Set the Url
        spec.pathParam("first","users");

        //Set the expected Data

        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","leader");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get the response
        Response response=given().contentType(ContentType.JSON).spec(spec).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        Map<String,String>actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("leader"),actualData.get("leader"));





    }
}
