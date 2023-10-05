package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityCreationResponse {

    @JsonProperty("response")
    private String entityId;

    public String getEntityId() {
        return entityId;
    }
}
