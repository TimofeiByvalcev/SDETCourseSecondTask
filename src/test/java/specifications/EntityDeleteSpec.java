package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Class provides a specification for delete request.
 */
public class EntityDeleteSpec extends BaseSpec {

    /**
     * Method specify URL and content type of request.
     * Takes a base url as parameter.
     */
    public static RequestSpecification deleteRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.TEXT)
                .build();
    }

    /**
     * Method specify an expected status code of response.
     */
    public static ResponseSpecification deleteResponseSuccessSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
