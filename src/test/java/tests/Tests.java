package tests;

import endpoints.Endpoints;
import helpers.DataPreparation;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requestModels.EntityRequest;
import responseModels.EntityCreationResponse;
import responseModels.EntityResponse;
import specifications.EntityUpdateSpec;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static specifications.EntityCreateSpec.*;
import static specifications.EntityDeleteSpec.*;
import static specifications.EntityGetAllSpec.*;
import static specifications.EntityGetSpec.*;
import static specifications.EntityUpdateSpec.updateRequestSpec;
import static specifications.EntityUpdateSpec.updateResponseSuccessSpec;

/**
 * Class provides an API tests.
 */
public class Tests extends BaseTest {

    /**
     * createEntityTest() check that entity with valid data was created.
     */
    @Owner("Tim Byvalcev")
    @DisplayName("Creating entity with valid data")
    @Test
    public void createEntityTest() {

        installSpec(createRequestSpec(Endpoints.getBaseUrl()), createResponseSuccessSpec());

        EntityRequest entityRequest = DataPreparation.createEntity();

        EntityCreationResponse entityId = new EntityCreationResponse(given()
                .body(entityRequest)
                .when()
                .post(Endpoints.getEntityCreate())
                .then().log().all()
                .extract().body().asString());
        assertNotEquals("", entityId.getId(), "Id isn't returned after creation");

        EntityResponse createdEntity = DataPreparation.getGeneratedEntity(entityId.getId());

        assertEquals(createdEntity.getId(), entityId.getId(), "Id is saved incorrectly after entity creation");
        assertEquals(createdEntity.getTitle(), entityRequest.getTitle(), "Title is saved incorrectly after entity creation");
    }

    /**
     * getEntityByIdTest() check that created entity can be gotten by id.
     */
    @Owner("Tim Byvalcev")
    @DisplayName("Get entity by Id")
    @Test
    public void getEntityByIdTest() {

        EntityRequest entityRequest = DataPreparation.createEntity();

        String creationResponse = DataPreparation.generateEntity(entityRequest).getId();

        installSpec(getRequestSpec(Endpoints.getBaseUrl()), getResponseSuccessSpec());

        EntityResponse entityResponse = given()
                .when()
                .get(Endpoints.getEntityGetId() + creationResponse)
                .then().log().all()
                .extract().body().as(EntityResponse.class);
        assertEquals(entityResponse.getId(), creationResponse, "Id is saved incorrectly after entity creation");
        assertEquals(entityResponse.getTitle(), entityRequest.getTitle(), "Title is saved incorrectly after entity creation");
    }

    /**
     * deleteEntityByIdTest() check that created entity can be deleted by id.
     */
    @Owner("Tim Byvalcev")
    @DisplayName("Delete entity by Id")
    @Test
    public void deleteEntityByIdTest() {

        EntityRequest entityRequest = DataPreparation.createEntity();

        String entityId = DataPreparation.generateEntity(entityRequest).getId();

        installSpec(deleteRequestSpec(Endpoints.getBaseUrl()), deleteResponseSuccessSpec());
        Response entityDeleteResponse = given()
                .when()
                .delete(Endpoints.getEntityDeleteId() + entityId);
    }

    /**
     * getAllEntitiesTest() check that previously created entities can be gotten as list.
     */
    @Owner("Tim Byvalcev")
    @DisplayName("Get all entities as list")
    @Test
    public void getAllEntitiesTest() {
        installSpec(getAllRequestSpec(Endpoints.getBaseUrl()), getAllResponseSuccessSpec());

        List<EntityResponse> entities = given()
                .when()
                .get(Endpoints.getEntityGetAll())
                .then().log().all()
                .extract().body().jsonPath().getList("Entity", EntityResponse.class);

        entities.forEach(x -> assertTrue(x.getTitle().contains("Super")));

        assertTrue(entities.stream().allMatch(x -> Integer.parseInt(x.getId()) > 0));

    }

    /**
     * updateEntityByIdTest() check that created entity can be updated successfully.
     */
    @Owner("Tim Byvalcev")
    @DisplayName("Update entity by id")
    @Test
    public void updateEntityByIdTest() {

        EntityRequest entityRequest = DataPreparation.createEntity();

        String entityId = DataPreparation.generateEntity(entityRequest).getId();

        EntityUpdateSpec.installSpec(updateRequestSpec(Endpoints.getBaseUrl()), updateResponseSuccessSpec());

        Response entityUpdateResponse = given()
                .body(entityRequest)
                .when()
                .patch(Endpoints.getEntityPatchId() + entityId);

        EntityResponse patchedEntity = DataPreparation.getGeneratedEntity(entityId);

        assertEquals(entityRequest.getTitle(), patchedEntity.getTitle());

    }

}
