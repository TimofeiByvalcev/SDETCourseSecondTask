package requestModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private AdditionRequest additionRequest;

    /**
     * List of important numbers.
     */
    private ArrayList<Integer> important_numbers;

    /**
     * Entity title.
     */
    private String title;

    /**
     * Entity status.
     */
    private boolean verified;

    /**
     * Constructor for Entity class object.
     * Takes as parameters addition, importantNumbers, title, verified.
     */
    @ConstructorProperties({"addition", "importantNumbers", "title", "verified"})
    public EntityRequest(AdditionRequest additionRequest, ArrayList<Integer> important_numbers, String title, Boolean verified) {
        this.additionRequest = additionRequest;
        this.important_numbers = important_numbers;
        this.title = title;
        this.verified = verified;
    }

    /**
     * Method returns an Addition class object.
     */
    public AdditionRequest getAddition() {
        return additionRequest;
    }

    /**
     * Method returns a list of important numbers.
     */
    public ArrayList<Integer> getImportant_numbers() {
        return important_numbers;
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
     * Method set an Addition class object
     */
    public void setAddition(AdditionRequest additionRequest) {
        this.additionRequest = additionRequest;
    }

    /**
     * Method set a list of important numbers.
     */
    public void setImportant_numbers(ArrayList<Integer> important_numbers) {
        this.important_numbers = important_numbers;
    }

    /**
     * Method set an entity title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method set an entity status.
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
