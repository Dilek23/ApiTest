package getRequest;

import baseURLs.ZippoPotamApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojoDatas.ZippoPotamPlaces;
import pojoDatas.ZippoPotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get11 extends ZippoPotamApiBaseUrl {
    /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */
    @Test
    public void get11(){
       specification.pathParams("countryPath","TR","CodePath",34010);

        ZippoPotamPlaces zippoPotamPlaces=new ZippoPotamPlaces("Maltepe Mah.","32.3609",
                "İstanbul", "34", "40.1589");

        ZippoPotamPojos zippoPotamPojos=new ZippoPotamPojos("34010","Turkey",
                "TR",zippoPotamPlaces);

        System.out.println("Expected data= " + zippoPotamPojos);

        Response response = given().
                spec(specification).
                when().
                get("/{countryPath}/{CodePath}");

        System.out.println("Response: ");
        response.prettyPrint();

        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        Assert.assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
        Assert.assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
        Assert.assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualDataMap.get("country abbreviation"));
        Assert.assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),
              (((Map)((List)actualDataMap.get("places")).get(0)).get("latitude")));


    }

}
