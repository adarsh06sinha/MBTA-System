package com.adarsh.assignment.mbtasystem.controller;

import com.adarsh.assignment.mbtasystem.TrainDeparture;
import com.adarsh.assignment.mbtasystem.service.MbtaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class MbtaApiRestController {
    @Autowired
    private MbtaApiService mbtaApiService;

    @GetMapping("/next-departures")
    public List<TrainDeparture> getNextDepartures() {
        return mbtaApiService.getNextTrainDepartures();
    }

    @GetMapping("/current-time")
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }
}
