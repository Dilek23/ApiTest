package getRequest;


import baseURLs.TheMovieBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends TheMovieBaseUrl {
    /*
        Given
            https://api.themoviedb.org/3/movie/popular

        bdf9faae90623f793a48b4d75c6a634d
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.
       Apıkey=bdf9faae90623f793a48b4d75c6a634d
     */



      /*
        1) Set URL
        2) Expecta Data   ---> Map, List, Arr
        3) Send REquest
        4) Assertion
         */


        //Step 1: Set URL:

    /*
     https://api.themoviedb.org/3/movie/popular

     */
   @Test
    public void get05(){
        specification.pathParams("moviePath","movie",
                        "popularPath","popular").
                queryParam("api_key","bdf9faae90623f793a48b4d75c6a634d");
        // KEy and Value dockumandan alınmıştır. Values
    //bizim kendime ait olan değerimizdir



    // Step 2: Set Expected Data (ignored)


    // Step 3: Send a Request


        Response response = given().
                spec(specification).
                when().
                get("/{moviePath}/{popularPath}");
        // get metodumun içierisne çalışacğaım endpoşntleri sytanx ıne uygun bir şekilde yazmalıyım.
    response.prettyPrint(); // like syso



    // Step 4: Asertion

    /*
    Then
        Status Code un "200" olduğunu Assert et
	And
        Content Type ın "application/json" olduğunu assert et
	And
	    id lerin içerisnde
	    646389
        536554
        640146 olduğunu assert ediniz.
     */


    response.then().assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("results.id", Matchers.hasItems(646389,536554,640146));

    }


}
