package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Class provides a specification for get by id request.
 */
public class EntityGetSpec extends BaseSpec {

    /**
     * Method specify URL and content type of request.
     * Takes a base url as parameter.
     */
    public static RequestSpecification getRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * Method specify an expected status code and content type of response.
     */
    public static ResponseSpecification getResponseSuccessSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
