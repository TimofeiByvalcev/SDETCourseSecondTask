package requestModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;

/**
 * Class provides request model for the part of the entity request model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionRequest {

    /**
     * Additional info.
     */
    private String additionalInfo;

    /**
     * Additional number.
     */
    private Integer additionalNumber;

    /**
     * Constructor for Addition class object.
     * Takes as parameters additional_info and additional_number.
     */
    @ConstructorProperties({"additional_info", "additional_number"})
    public AdditionRequest(String additionalInfo, Integer additionalNumber) {
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
    }

    /**
     * Method returns an additional info.
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Method set an additional info.
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Method return an additional number.
     */
    public Integer getAdditionalNumber() {
        return additionalNumber;
    }

    /**
     * Method set an additional number
     */
    public void setAdditionalNumber(Integer additionalNumber) {
        this.additionalNumber = additionalNumber;
    }
}
