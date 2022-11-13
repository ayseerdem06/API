package practice;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C02_reqresPojo_post extends ReqresBaseUrl {
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
        // Set the url
        spec.pathParam("first","users");

        //Set the expected Data
        ReqresPojo expectedData=new ReqresPojo("morpheus","leader");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get the response
        Response response = given().contentType(ContentType.JSON).spec(spec).body(expectedData).with().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        ReqresPojo actualData = response.as(ReqresPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());



    }
}
