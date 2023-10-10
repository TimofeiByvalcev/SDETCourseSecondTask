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
public class EntityResponse {

    /**
     * Entity id.
     */
    @Getter
    @Setter
    private String id;

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
    private Boolean verified;

    /**
     * An AdditionResponse object.
     */
    @Getter
    @Setter
    private AdditionResponse additionResponse;

    /**
     * Entity important numbers.
     */
    @Getter
    @Setter
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
