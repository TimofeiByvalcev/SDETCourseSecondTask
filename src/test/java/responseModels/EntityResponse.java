package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
                          Boolean verified, AdditionResponse additionResponse, ArrayList<Integer> important_numbers) {
        this.id = id;
        this.title = title;
        this.verified = verified;
        this.additionResponse = additionResponse;
        this.importantNumbers = important_numbers;
    }

    /**
     * Method return an entity id.
     */
    public String getId() {
        return id;
    }

    /**
     * Method returns an entity title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method returns an entity status.
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Method returns AdditionResponse object.
     */
    public AdditionResponse getAddition() {
        return additionResponse;
    }

    /**
     * Method returns a list of important numbers.
     */
    public ArrayList<Integer> getImportantNumbers() {
        return importantNumbers;
    }
}
