package deleteRequest;

import baseURLs.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.BookingDatespojo;
import pojoDatas.HerOkuBookingDatesPut02Pojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class Delete01 extends HerokuappBaseUrl {


     /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */
   @Test
   public void delete01(){
       specification.pathParams("bookingPath","booking",
               "idPath",6);



       Response response = given().
               spec(specification).
               contentType(ContentType.JSON).
               header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
               when().
               delete("/{bookingPath}/{idPath}");
       System.out.println("Response:");
       response.prettyPrint();

       response.then().assertThat().statusCode(201).body(containsString("Created"));

    //   Assert.assertEquals();
   }



}
