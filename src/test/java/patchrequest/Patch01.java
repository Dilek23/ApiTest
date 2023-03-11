package patchrequest;

import baseURLs.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Patch01 extends HerokuappBaseUrl {
/*
     Given
	        1) https://restful-booker.herokuapp.com/booking/32
	        2) {
    "firstname" : "Drake",
    "lastname" : "CW"
}
3) Auth olarak --> Header da Basic YWRtaW46cGFzc3dvcmQxMjM=


        When
	 		Kullanıcı PATCH Req atar
	    Then
	   	   Status code is 200
	   	   And response body de firs ve lastname değiştiğini assert ediniz.
	   	    {
    "firstname": "Drake",
    "lastname": "CW",
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
    public void patch01(){

    //Step 1: Set URL
    //https://restful-booker.herokuapp.com/booking/33
    specification.pathParams("bookingPath","booking",
            "idPath",33);


  File file=new File("src/test/java/testData/FirstNameLastName");
    HashMap<String,Object> expectedDataAndBody=JsonToJava.convertJsonToJavaObject(file, HashMap.class);


    Response response = given().
            spec(specification).
            contentType(ContentType.JSON).
            header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
            body(expectedDataAndBody).
            when().
            patch("/{bookingPath}/{idPath}");
    System.out.println("Response:");
    response.prettyPrint();

}

}
