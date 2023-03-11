package testData;

import utilities.JsonToJava;

import java.util.HashMap;

public class JsonPlaceHolderTestData {

    //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.

        /*
         JsonPlaceHolderBaseURL jsonPlaceHolderBaseURL = new JsonPlaceHolderBaseURL();

        String ex = jsonPlaceHolderBaseURL.createEdilen(userId);
         */
/*
   {
        "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
    }

 */
        String expData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "}";


    public static HashMap<String,Object> expectedData;
    public HashMap setUpDataTodos(){
        expectedData = new HashMap<>();

        expectedData.put("StatusCode",200);
        expectedData.put("Server","cloudflare");
        expectedData.put("userId",1);
        expectedData.put("id",2.0);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        return expectedData;
    }
    public HashMap<String,Object> setUpDataJson(){

       HashMap<String,Object> expectedDatajson = new HashMap<>();

        expectedDatajson.put("userId",10);
        expectedDatajson.put("id",198);
        expectedDatajson.put("title","quis eius est sint explicabo");
        expectedDatajson.put("completed",true);
        return expectedDatajson;


    }
    public HashMap<String,Object> setUpForPutReq(){

        /*
         {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
         */
        expectedData = new HashMap<>();

      expectedData.put("userId",01);
      expectedData.put("title","CW FSQA API Tutorial");
      expectedData.put("completed",true);

      return expectedData;


    }
}
