package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Class provides a specification for patch by id request.
 */
public class EntityUpdateSpec {

    /**
     * Method specify URL and content type of request.
     * Takes a base url as parameter.
     */
    public static RequestSpecification updateRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }


    /**
     * Method specify an expected status code and content type of response.
     */
    public static ResponseSpecification updateResponseNoContent204Spec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();

    }

    /**
     * Method for install specifications.
     */
    public static void installUpdateSpec(RequestSpecification request, ResponseSpecification response204) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response204;
    }
}
