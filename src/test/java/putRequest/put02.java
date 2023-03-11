package putRequest;

import baseURLs.HerokuappBaseUrl;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.BookingDatespojo;
import pojoDatas.HerOkuBookingDatesPut02Pojo;
import pojoDatas.HerOkuRestPut02Pojo;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class put02 extends HerokuappBaseUrl {
  /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/37
	        2) {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
        3) Kullanıcı Auth. olarak ilk olarak  Header a Cookie ile daha sonra ise Basic Autoh ile  req bulunmalı.
            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> token=001832eb39ba0ca
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
    "firstname" : "Drake",
    "lastname" : "F..",
    "totalprice" : 4000,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2022-01-01",
        "checkout" : "2023-01-01"
    },
    "additionalneeds" : "API and Appium"
}
     */


    //"token": "884099be87f40a6"

    @Test
    public void put02(){

       //Set URL
       //https://restful-booker.herokuapp.com/booking/37
       specification.pathParams("bookingPath","booking",
               "idPath",93);


       //Set Expected and Request Body

       /*
       {
   "firstname" : "Drake",
   "lastname" : "F..",
   "totalprice" : 4000,
   "depositpaid" : true,
   "bookingdates" : {
       "checkin" : "2022-01-01",
       "checkout" : "2023-01-01"
   },
   "additionalneeds" : "API and Appium"

      //System.out.println(restFulBookingPojo);
       //Step 3: Send a request;

       //Cookie  -----  token=<token_value>

        */

        HerOkuBookingDatesPut02Pojo bookingDatesPojoPost = new HerOkuBookingDatesPut02Pojo("2022-01-01","2023-01-01");
        BookingDatespojo restFulBookingPojo = new BookingDatespojo("Drake","F..",4000,true,"API and Appium",bookingDatesPojoPost);


//  header("Cookie","token=" + "84e4c34a78ccdb6").
       Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
              header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
                body(restFulBookingPojo).
               when().
            put("/{bookingPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();

    //Step 4: Assertion

    JsonPath jsonPath = response.jsonPath();
    assertEquals(jsonPath.getString("firstname"),restFulBookingPojo.getFirstname());
    assertEquals(jsonPath.getString("lastname"),restFulBookingPojo.getLastname());
    assertEquals(jsonPath.getInt("totalprice"),restFulBookingPojo.getTotalprice());
    assertEquals(jsonPath.getBoolean("depositpaid"),restFulBookingPojo.isDepositpaid());
    assertEquals(jsonPath.getString("bookingdates.checkin"),bookingDatesPojoPost.getCheckin());
    assertEquals(jsonPath.getString("bookingdates.checkout"),bookingDatesPojoPost.getCheckout());
    assertEquals(jsonPath.getString("additionalneeds"),restFulBookingPojo.getAdditionalneeds());


}
    //Forbidden     ----->>>> Token değiştirdim

    //401  ----->> Unauth.     -----------------    Authj. ile ilgli herahngi bir value bulunmadığı zaman.
    //403 ------>> Forbidden    - - -- - -- - -- Token veya ilgili auth. metodu ne ise onunla ilgili oalrak value var fakat yanlış yahut expire olmuş olabilir.


    }




