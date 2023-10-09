package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;


/**
 * Class provides a response model for entity creation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityCreationResponse {

    /**
     * Created entity id.
     */
    private String id;

    /**
     * Constructor for EntityCreationResponse object. Takes an entity id as parameter.
     */
    public EntityCreationResponse(String id) {
        this.id = id;
    }

    /**
     * Method get an entity id.
     */
    public String getId() {
        return id;
    }
}
