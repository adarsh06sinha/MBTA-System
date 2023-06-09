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
public class PredictionAttributes {
    @JsonProperty("departure_time")
    private String departureTime;

    @JsonProperty("destination")
    private String destination;

    // Getters and setters
}
