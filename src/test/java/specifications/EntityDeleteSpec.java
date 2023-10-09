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
public class EntityDeleteSpec {

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
    public static ResponseSpecification deleteResponseNoContent204Spec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();

    }

    /**
     * Method for install specifications.
     */
    public static void installDeleteSpec(RequestSpecification request, ResponseSpecification response204) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response204;
    }
}
