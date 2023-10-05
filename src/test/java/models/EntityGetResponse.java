package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityGetResponse {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String title;
    @JsonProperty
    private boolean verified;
    @JsonProperty
    private Addition addition;
    @JsonProperty
    private ArrayList<Integer> importantNumbers;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Addition {

        @JsonProperty
        private Integer id;

        @JsonProperty
        private String additionalInfo;

        @JsonProperty
        private Integer additionalNumber;
    }

}
