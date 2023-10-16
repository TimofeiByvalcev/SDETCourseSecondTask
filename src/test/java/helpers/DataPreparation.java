package helpers;

import endpoints.Endpoints;
import io.restassured.http.ContentType;
import requestModels.AdditionRequest;
import requestModels.EntityRequest;
import responseModels.EntityCreationResponse;
import responseModels.EntityResponse;
import specifications.EntityCreateSpec;
import specifications.EntityGetSpec;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static specifications.EntityCreateSpec.createRequestSpec;
import static specifications.EntityCreateSpec.createResponseSuccessSpec;
import static specifications.EntityGetSpec.getRequestSpec;
import static specifications.EntityGetSpec.getResponseSuccessSpec;

/**
 * Class provides methods for creating/getting entities before test in the case when no entities presented in DB.
 */
public class DataPreparation {

    public static Integer[] convertStringToIntegerArray(String[] stringArray) {
        Integer[] importantNumbers = Arrays.stream(stringArray).map(Integer::valueOf).toArray(Integer[]::new);
        return importantNumbers;
    }

    public static EntityRequest createEntity() {
        EntityRequest entityRequest = new EntityRequest(new AdditionRequest(ReadProperties.readProperty("entity.additional.info"),
                Integer.valueOf(ReadProperties.readProperty("entity.additional.number"))),
                new ArrayList<Integer>(Arrays.asList(convertStringToIntegerArray(ReadProperties.readProperty("entity.important.numbers").split("")))),
                ReadProperties.readProperty("entity.title"),
                ReadProperties.readProperty("entity.verified").equals("true"));
        return entityRequest;

    }

    /**
     * Method create an entity in DB via API endpoint.
     * Take an Entity class object as parameter.
     * Return id of created entity.
     */
    public static EntityCreationResponse generateEntity(EntityRequest entityRequest) {
        EntityCreateSpec.installSpec(createRequestSpec(Endpoints.getBaseUrl()), createResponseSuccessSpec());
        EntityCreationResponse entityId = new EntityCreationResponse(given()
                .body(entityRequest)
                .when()
                .post(Endpoints.getEntityCreate())
                .then().log().all()
                .extract().body().asString());
        return entityId;
    }

    /**
     * Method get an entity from DB via API endpoint.
     * Take an entity id as parameter.
     * Return EntityResponse class object.
     */
    public static EntityResponse getGeneratedEntity(String id) {
        EntityGetSpec.installSpec(getRequestSpec(Endpoints.getBaseUrl()), getResponseSuccessSpec());
        EntityResponse createdEntity = given()
                .when()
                .contentType(ContentType.JSON)
                .get(Endpoints.getEntityGetId() + id)
                .then().log().all()
                .extract().body().as(EntityResponse.class);
        return createdEntity;
    }
}
