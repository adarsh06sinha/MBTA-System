package com.adarsh.assignment.mbtasystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TrainDeparture {
    private String line;
    private String destination;
    private int minutesUntilDeparture;

    // Constructor, getters, and setters
}
