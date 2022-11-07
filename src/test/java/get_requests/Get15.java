package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
           {
                "firstname": "Guoqiang",
                "lastname": "Morante Briones",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
             },
                "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void get15() {
        // set the URL
        spec.pathParams("first","booking","second",22);

        // Set the extected Data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Guoqiang","Morante Briones",111,true,bookingDatesPojo,"Breakfast");

        // Sen the Request and Get the Response
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertion

        BookingPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);

        // Soft Assertion
        //1.Adım : Soft assert objesi olustur
        SoftAssert softAssert=new SoftAssert();

        //2.Adım : assertion yap
        softAssert.assertEquals(200,response.getStatusCode());
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Firstname uyusmadı");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastname uyusmadı");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Totalprice uyusmadı");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Depositpaid uyusmadı");
        softAssert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds(),"Additionalneeds uyusmadı");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getCheckin(),"Checkin uyusmadı");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),bookingDatesPojo.getCheckout(),"Checkout uyusmadı");

        //3.Adım : asserAll() methodunu kullan
        softAssert.assertAll();


        // Hard Assertion
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());




    }
}
