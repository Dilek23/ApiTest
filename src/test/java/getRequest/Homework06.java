package getRequest;

import baseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GorestPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework06 extends GoRestCoBaseURL {
 /*
        Given
            https://gorest.co.in/public/v2/users/697102
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
      {
{
    "id": 712630,
    "name": "Mangalya Bhat",
    "email": "bhat_mangalya@littel-kshlerin.info",
    "gender": "female",
    "status": "inactive"
}
}


  */
@Test
    public void getHomework(){

    specification.pathParams("usersPath","users","idPath","712630");
    Response response=given().
            spec(specification).
            when().
            get("/{usersPath}/{idPath}");
    System.out.println("Response");

    response.prettyPrint();
  response.then().assertThat().statusCode(200);
    GorestPojo expectedData=new GorestPojo(712630,"Mangalya Bhat","bhat_mangalya@littel-kshlerin.info","female","inactive");
    System.out.println("expectedData = " + expectedData);
    Map<String,Object> actualDataMap=response.as(HashMap.class);
    Assert.assertEquals(expectedData.getId(),actualDataMap.get("id"));
    Assert.assertEquals(expectedData.getName(),actualDataMap.get("name"));
    Assert.assertEquals(expectedData.getEmail(),actualDataMap.get("email"));
    Assert.assertEquals(expectedData.getGender(),actualDataMap.get("gender"));
    Assert.assertEquals(expectedData.getStatus(),actualDataMap.get("status"));




}







}
