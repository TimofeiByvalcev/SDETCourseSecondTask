package endpoints;

import helpers.ReadProperties;

/**
 * Class provides endpoints URI for CRUD operations with entity.
 */
public class Endpoints {

    /**
     * Base URL
     */
    private static String baseUrl = ReadProperties.readProperty("baseUri");

    /**
     * Uri of endpoint for entity creation.
     */
    private static String entityCreate = "/api/create";

    /**
     * Uri of endpoint for entity deletion.
     */
    private static String entityDeleteId = "/api/delete/";

    /**
     * Uri of endpoint for get entity.
     */
    private static String entityGetId = "/api/get/";

    /**
     * Uri of endpoint for get entities.
     */
    private static String entityGetAll = "/api/getAll";

    /**
     * Uri of endpoint for update entity.
     */
    private static String entityPatchId = "/api/patch/";

    /**
     * getEntityCreate() return uri of endpoint for entity creation.
     */
    public static String getEntityCreate() {
        return entityCreate;
    }

    /**
     * getEntityDelete() return uri of endpoint for entity deletion by id.
     */
    public static String getEntityDeleteId() {
        return entityDeleteId;
    }

    /**
     * getEntityBaseUrl() return base url.
     */
    public static String getBaseUrl() {
        return baseUrl;
    }

    /**
     * getEntityGetId() return uri of endpoint for get entity by id.
     */
    public static String getEntityGetId() {
        return entityGetId;
    }

    /**
     * getEntityGetAll() return uri endpoint for get all entities.
     */
    public static String getEntityGetAll() {
        return entityGetAll;
    }

    /**
     * getEntityPatchId() return uri endpoint for entity update by id.
     */
    public static String getEntityPatchId() {
        return entityPatchId;
    }
}
