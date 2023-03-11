package getRequest;

import baseURLs.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework05 extends HerokuappBaseUrl {

/*

*/
    @Test
    public void homework05(){
        specification.pathParam("bookingPath","booking");
        Response response=given().spec(specification).when().
                get("/{bookingPath}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


    }





}
