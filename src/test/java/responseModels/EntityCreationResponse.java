package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;


/**
 * Class provides a response model for entity creation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
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
}
