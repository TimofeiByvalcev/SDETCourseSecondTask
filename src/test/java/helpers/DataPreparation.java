package helpers;

import endpoints.Endpoints;
import io.restassured.http.ContentType;
import requestModels.EntityRequest;
import responseModels.EntityCreationResponse;
import responseModels.EntityResponse;
import specifications.EntityCreateSpec;
import specifications.EntityGetSpec;

import static io.restassured.RestAssured.given;
import static specifications.EntityCreateSpec.createRequestSpec;
import static specifications.EntityCreateSpec.createResponseSpecOK200;
import static specifications.EntityGetSpec.getRequestSpec;
import static specifications.EntityGetSpec.getResponseSpecOK200;

/**
 * Class provides methods for creating/getting entities before test in the case when no entities presented in DB.
 */
public class DataPreparation {

    /**
     * Method create an entity in DB via API endpoint.
     * Take an Entity class object as parameter.
     * Return id of created entity.
     */
    public static EntityCreationResponse generateEntity(EntityRequest entityRequest) {
        EntityCreateSpec.installCreateSpec(createRequestSpec(Endpoints.getBaseUrl()), createResponseSpecOK200());
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
        EntityGetSpec.installGetSpec(getRequestSpec(Endpoints.getBaseUrl()), getResponseSpecOK200());
        EntityResponse createdEntity = given()
                .when()
                .contentType(ContentType.JSON)
                .get(Endpoints.getEntityGetId() + id)
                .then().log().all()
                .extract().body().as(EntityResponse.class);
        return createdEntity;
    }
}
