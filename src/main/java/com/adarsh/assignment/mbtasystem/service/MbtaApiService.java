package com.adarsh.assignment.mbtasystem.service;

import com.adarsh.assignment.mbtasystem.MbtaApiResponse;
import com.adarsh.assignment.mbtasystem.TrainDeparture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MbtaApiService {
    @Value("${mbta.api.url}")
    private String apiUrl;

    public List<TrainDeparture> getNextTrainDepartures() {
        String url = apiUrl + "/predictions/?filter[stop]=place-pktrm&sort=departure_time&include=route";
        RestTemplate restTemplate = new RestTemplate();
        MbtaApiResponse response = restTemplate.getForObject(url, MbtaApiResponse.class);
        return mapResponseToTrainDepartures(response);
    }

    private List<TrainDeparture> mapResponseToTrainDepartures(MbtaApiResponse response) {
        List<TrainDeparture> trainDepartures = new ArrayList<>();

        if (response != null && response.getData() != null) {
            trainDepartures = response.getData().stream()
                    .filter(prediction -> prediction.getAttributes() != null)
                    .map(prediction -> {
                        String line = prediction.getRelationships().getRoute().getData().getId();
                        String destination = prediction.getAttributes().getDestination();
                        String departureTime = prediction.getAttributes().getDepartureTime();
                        int minutesUntilDeparture = 0;  // Default value if departureTime is null

                        if (departureTime != null) {
                            // Convert the timestamp string to a valid date object
                            Instant instant = Instant.parse(departureTime);
                            LocalDateTime departureDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                            // Calculate the minutes until departure
                            LocalDateTime currentDateTime = LocalDateTime.now();
                            Duration duration = Duration.between(currentDateTime, departureDateTime);
                            minutesUntilDeparture = (int) duration.toMinutes();
                        }

                        return new TrainDeparture(line, destination, minutesUntilDeparture);
                    })
                    .limit(10)
                    .collect(Collectors.toList());
        }

        return trainDepartures;
    }

}

