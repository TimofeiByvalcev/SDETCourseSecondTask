package requestModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

/**
 * Class provides request model for the part of the entity request model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionRequest {

    /**
     * Additional info.
     */
    @Getter
    @Setter
    private String additionalInfo;

    /**
     * Additional number.
     */
    @Getter
    @Setter
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
}
