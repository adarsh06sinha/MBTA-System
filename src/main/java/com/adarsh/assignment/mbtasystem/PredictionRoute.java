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
public class PredictionRoute {
    @JsonProperty("data")
    private PredictionRouteData data;

    // Getters and setters
}

