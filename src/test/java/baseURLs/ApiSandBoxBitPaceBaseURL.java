package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ApiSandBoxBitPaceBaseURL {
    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL(){

        specification = new RequestSpecBuilder().
                setBaseUri("https://dev.bitpace.com/api/v1").
                build();
    }


}
