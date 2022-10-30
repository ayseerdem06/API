package get_reguest;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get08b extends JsonplaceholderBaseUrl {

    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }

    // Set the URL
    // Set The Expected Data ( put,post,patch)
    // Send The Request And Get The Response
    // Do Assertion
     */
    @Test
    public void test08() {
        // Set the URL
        spec.pathParams("first","todos","second",2);

        // Set The Expected Data ( put,post,patch)
        Map<String,Object>expectedDate=new HashMap<>();
        expectedDate.put("userId",1);
        expectedDate.put("id",2);
        expectedDate.put("title","quis ut nam facilis et officia qui");
        expectedDate.put("completed",false);
        System.out.println("ExpectedData : "+ expectedDate);

        // Send The Request And Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);  //   //De-Serialization: Json datayı Java objesine çevirme
        System.out.println("ActualData: "+ actualData);
        assertEquals(expectedDate.get("userId"),actualData.get("userId"));
        assertEquals(expectedDate.get("id"),actualData.get("id"));
        assertEquals(expectedDate.get("title"),actualData.get("title"));
        assertEquals(expectedDate.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());

    }
}
