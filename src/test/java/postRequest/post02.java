package postRequest;

import baseURLs.GoRestCoBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;
import pojoDatas.GoRestApiTestData;
import pojoDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class post02  extends GoRestCoBaseURL {


        /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */

  @Test
   public void post02(){

       //Set Base URL
       //https://gorest.co.in/public/v2/users
       specification.pathParam("usersPath","users");


       //Step 2: Set Expected and Request Body
       GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
       HashMap<String,String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("adilekk","male",
               "dila@com","active");

       System.out.println("reqBodyAndExpectedDataMap: " + reqBodyAndExpectedDataMap);


       //Step 3: Send a request
       Response response = given().
               spec(specification).
               contentType(ContentType.JSON).
               body(reqBodyAndExpectedDataMap).
               when().
               header("Authorization","Bearer 6be1e4991891859bdc5af3f84cbc2c9df3445e891a34d2232f6504fef3690d51").
               post("/{usersPath}");


       System.out.println("Response Body: " );
       response.prettyPrint();


       //Step 4: Assertion

       //Pojo kullanrak assert ediniz.
      GoRestApiPojo reguestBody= new GoRestApiPojo("adilekk","dila@com","male","active");
   //   HashMap<String,Object> expectedBodyMap= JsonToJava.convertJsonToJavaObject(reguestBody.toString(), HashMap.class);
// Ex: <<PojoClasName>> = response.as(<<PojoClasName>>.class)

      HashMap<String,Object> actualBodyMap=JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
     Assert.assertEquals(reguestBody.getName(),actualBodyMap.get("name"));
     Assert.assertEquals(reguestBody.getEmail(),actualBodyMap.get("email"));
     Assert.assertEquals(reguestBody.getGender(),actualBodyMap.get("gender"));
     Assert.assertEquals(reguestBody.getStatus(),actualBodyMap.get("status"));


      }



   }





