package postRequest;

import baseURLs.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.DummyRestApiExPojo;
import pojoDatas.DummyRestApiReqPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends DummyRestApiBaseURL {
      /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}
   */

    @Test
    public void post03() {
        specification.pathParam("createPath", "create");

        String requestBody = "{\n" +
                "  \"name\": \"Drak F.\",\n" +
                "  \"salary\": \"4000\",\n" +
                "  \"age\": \"37\"\n" +
                "}";
        DummyRestApiExPojo dummyRestApiPojo=new DummyRestApiExPojo("Drake F","40000","27");
/*
    {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",

    },
 */
        DummyRestApiReqPojo dummyResTApiExPojo=new DummyRestApiReqPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");
        Response response=given().
                spec(specification).contentType(ContentType.JSON).
                auth().basic("admin","password123").body( dummyRestApiPojo).when().post("/{createPath}");
        System.out.println("Response: ");
        response.prettyPrint();

        DummyRestApiExPojo actualData = response.as(DummyRestApiExPojo.class);
        System.out.println("Actual Data: " + actualData);



    }


}
