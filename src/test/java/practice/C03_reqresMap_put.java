package practice;

import base_urls.ReqresBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C03_reqresMap_put extends ReqresBaseUrl {

    //3: Map ile ve Pojo Class ile ayrı ayrı Gson kullanarak yapınız.

/*
        Given
            1) https://reqres.in/api/users/2
            2) {
                "name": "morpheus",
                "job": "zion president"
                }
        When
            I send Put Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "zion president",
                                                "updatedAt": "2022-10-02T11:35:05.693Z"
                                            }
*/

    @Test
    public void test03() {
        // Map ile :

        //Set the Url
        spec.pathParams("first","users","second",2);

        //Set the Expected Data
        Map<String,String>expectedData=new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job","zion president");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Gson gson=new Gson();
        HashMap actualData = gson.fromJson(response.asString(),(HashMap.class));
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));





    }
}
