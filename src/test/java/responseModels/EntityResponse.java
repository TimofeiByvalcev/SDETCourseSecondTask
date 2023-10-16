package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.ArrayList;

/**
 * Class provides a response model for getting an entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EntityResponse {

    /**
     * Entity id.
     */
    private String id;

    /**
     * Entity title.
     */
    private String title;

    /**
     * Entity status.
     */
    private Boolean verified;

    /**
     * An AdditionResponse object.
     */
    private AdditionResponse additionResponse;

    /**
     * Entity important numbers.
     */
    private ArrayList<Integer> importantNumbers;

    /**
     * Constructor for EntityResponse class object.
     * Takes as parameters id, title, verified, addition, importantNumbers.
     */
    @ConstructorProperties({"id", "title", "verified", "addition", "importantNumbers"})
    public EntityResponse(String id, String title,
                          Boolean verified, AdditionResponse additionResponse, ArrayList<Integer> importantNumbers) {
        this.id = id;
        this.title = title;
        this.verified = verified;
        this.additionResponse = additionResponse;
        this.importantNumbers = importantNumbers;
    }
}
