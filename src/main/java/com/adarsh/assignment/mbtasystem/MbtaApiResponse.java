package com.adarsh.assignment.mbtasystem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MbtaApiResponse {
    @JsonProperty("data")
    private List<Prediction> data;

    // Getters and setters
}
