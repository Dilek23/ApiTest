package postRequest;

import baseURLs.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.HerOkuBookingDatesPut02Pojo;
import pojoDatas.HerOkuRestPut02Pojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HomeWork01 extends HerokuappBaseUrl {
    /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
                 }
                 "additionalneeds": "Full Stack Test Automation Course with API and Appium"
             }
        When
 		    Kullanıcı POST metodu ile request göderir
 	    Then
              Status Code un 200 olduğu doğrulanır
 		And
 		      Response Body nin aşağıdaki gibi olduğu verify edilir
 		    {
    "bookingid": 3844,
    "booking": {
        "firstname": "Drake",
        "lastname": "F.",
        "totalprice": 4000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2022-09-05",
            "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
}
     */

    @Test
    public void homeWork01() {

        //Set URL
        //https://restful-booker.herokuapp.com/booking/37
        specification.pathParams("bookingPath", "booking"
                );


        //Set Expected and Request Body
        HerOkuBookingDatesPut02Pojo bookingdate = new HerOkuBookingDatesPut02Pojo("2022-01-01", "2023-01-01");
        HerOkuRestPut02Pojo regBookingBody = new HerOkuRestPut02Pojo("Drake", "F..", 4000,
                true, "Full Stack Test Automation Course with API and Appium", bookingdate);

        Response response=given().spec(specification).contentType(ContentType.JSON).
                body(regBookingBody).when().post("/{bookingPath}");
      response.prettyPrint();


    }
}