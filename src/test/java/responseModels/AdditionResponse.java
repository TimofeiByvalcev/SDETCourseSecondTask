package responseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

/**
 * Class provides response model for the part of the entity response model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionResponse {

    /**
     * Addition id.
     */
    @Getter
    @Setter
    public Integer id;

    /**
     * Additional info.
     */
    @Getter
    @Setter
    @JsonProperty("additional_info")
    public String additionalInfo;

    /**
     * Additional number.
     */
    @Getter
    @Setter
    @JsonProperty("additional_number")
    public Integer additionalNumber;

    /**
     * Constructor for AdditionResponse class object.
     * Takes as parameters id, additional_info and additional_number.
     */
    @ConstructorProperties({"id", "additional_info", "additional_number"})
    public AdditionResponse(Integer id, String additionalInfo, Integer additionalNumber) {
        this.id = id;
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
    }
}
