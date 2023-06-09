package com.adarsh.assignment.mbtasystem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prediction {
    @JsonProperty("attributes")
    private PredictionAttributes attributes;

    @JsonProperty("relationships")
    private PredictionRelationships relationships;

    // Getters and setters
}

