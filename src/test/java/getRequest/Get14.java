package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import testData.JsonPlaceHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Get14 extends JsonPlaceHolderBaseURL {

 /*


        Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */
    @Test
    public void ge14(){
        specification.pathParams("todosPath","todos","idPath","198");
        String expectedAta=" \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "   \"title\": \"quis eius est sint explicabo\",\n" +
                "   \"completed\": true";

        System.out.println("expectedAta = " + expectedAta);

    //Step 2: Set Expected Data

    String expectedData = "{\n" +
            "    \"userId\": 10,\n" +
            "    \"id\": 198,\n" +
            "    \"title\": \"quis eius est sint explicabo\",\n" +
            "    \"completed\": true\n" +
            "}";


    System.out.println("ExpectedDataString: " + expectedData);

    HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData,HashMap.class);
    System.out.println("EXPECTED DATA MAP: " + expectedDataMap);

    //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

    /*
     JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

    String ex = jsonPlaceHolderBaseURL.createEdilen(userId);
     */


    //Step 3: Send a request
    Response response = given().
            spec(specification).
            when().
            get("/{todosPath}/{idPath}");

    System.out.println("RESPONSE: ");
    response.prettyPrint();


    // Step 4: Assertion

    //Response
        //step 4 :Assertion
        //actualData response 'dan alınır.


        // Actual Data getirme yöntemleri
        // 1.HashMap<String,Object>actualDataMap =response.as(HashMap.class);//---> Gson
        // 2.JsonPath jsonPath=response.jsonPath();//--> json
        // 3.response.then().assertThat().body("");-->> response body
        // 4. HashMap<String,Object>actualDataMap = JavaToJson.convertJsonToJavaObject(response.asString(),HashMap.class); ---> object mapper
    //HashMap<String,Object> actualDataMap =  response.as(HashMap.class);   // ---> NOme Problemooo


    //  JsonPath jsonPath = response.jsonPath(); /// ----> NOme Problemooo

    //  response.then().assertThat().body(""); /// ---> Nome Problemo


    HashMap<String,Object> actualDataMapJSONToJAVA = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);

    System.out.println("actualDataMapJSONToJAVA: " + actualDataMapJSONToJAVA);
        for (String key:actualDataMapJSONToJAVA.keySet()){

            Assert.assertEquals(expectedDataMap.get(key),actualDataMapJSONToJAVA.get(key));

        }

    /*
    ASSERTION HOMEWORK
     */
        //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
         HashMap<String,Object>jsonmap=jsonPlaceHolderTestData.setUpDataJson();
        System.out.println("jsonmap = " + jsonmap);
        for (String key: actualDataMapJSONToJAVA.keySet()){
            Assert.assertEquals(jsonmap.get(key),actualDataMapJSONToJAVA.get(key));
        }


    }


}
