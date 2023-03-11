package getRequest;

import baseURLs.SwapiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Homework04 extends SwapiBaseUrl {

    @Test
    public void homework04() {
        specification.pathParams("vehiclesPath", "vehicles", "idPath", "4");
        //Kullanıcı GET Methodu ile Request Gönderir

        Response response = given().spec(specification).when().get("/{vehiclesPath}/{idPath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        String actualData = response.getBody().asString();
        String expectedData = "{\n" +
                "    \"name\": \"Sand Crawler\",\n" +
                "    \"model\": \"Digger Crawler\",\n" +
                "    \"manufacturer\": \"Corellia Mining Corporation\",\n" +
                "    \"cost_in_credits\": \"150000\",\n" +
                "    \"length\": \"36.8 \",\n" +
                "    \"max_atmosphering_speed\": \"30\",\n" +
                "    \"crew\": \"46\",\n" +
                "    \"passengers\": \"30\",\n" +
                "    \"cargo_capacity\": \"50000\",\n" +
                "    \"consumables\": \"2 months\",\n" +
                "    \"vehicle_class\": \"wheeled\",\n" +
                "    \"pilots\": [\n" +
                "        \n" +
                "    ],\n" +
                "    \"films\": [\n" +
                "        \"https://swapi.dev/api/films/1/\",\n" +
                "        \"https://swapi.dev/api/films/5/\"\n" +
                "    ],\n" +
                "    \"created\": \"2014-12-10T15:36:25.724000Z\",\n" +
                "    \"edited\": \"2014-12-20T21:30:21.661000Z\",\n" +
                "    \"url\": \"https://swapi.dev/api/vehicles/4/\"\n" +
                "}";
        Assert.assertEquals(expectedData, actualData);
    }
}
