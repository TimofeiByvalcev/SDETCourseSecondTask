package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;

/**
 * Class provides response model for the part of the entity response model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionResponse {

    /**
     * Addition id.
     */
    public Integer id;

    /**
     * Additional info.
     */
    public String additional_info;

    /**
     * Additional number.
     */
    public Integer additional_number;

    /**
     * Constructor for AdditionResponse class object.
     * Takes as parameters id, additional_info and additional_number.
     */
    @ConstructorProperties({"id", "additional_info", "additional_number"})
    public AdditionResponse(Integer id, String additional_info, Integer additional_number) {
        this.id = id;
        this.additional_info = additional_info;
        this.additional_number = additional_number;
    }

    /**
     * Method returns an addition id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Method returns an additional info.
     */
    public String getAdditional_info() {
        return additional_info;
    }

    /**
     * Method return an additional number.
     */
    public Integer getAdditional_number() {
        return additional_number;
    }
}
