package requestModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.ArrayList;

/**
 * Class provides a request model for entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityRequest {

    /**
     * Addition class object.
     */
    @Getter
    @Setter
    private AdditionRequest additionRequest;

    /**
     * List of important numbers.
     */
    @Getter
    @Setter
    @JsonProperty("important_numbers")
    private ArrayList<Integer> importantNumbers;

    /**
     * Entity title.
     */
    @Getter
    @Setter
    private String title;

    /**
     * Entity status.
     */
    @Getter
    @Setter
    private boolean verified;

    /**
     * Constructor for Entity class object.
     * Takes as parameters addition, importantNumbers, title, verified.
     */
    @ConstructorProperties({"addition", "importantNumbers", "title", "verified"})
    public EntityRequest(AdditionRequest additionRequest, ArrayList<Integer> importantNumbers, String title, Boolean verified) {
        this.additionRequest = additionRequest;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }
}
