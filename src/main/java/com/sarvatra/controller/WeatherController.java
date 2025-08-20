package com.sarvatra.controller;

import com.sarvatra.mode.WeatherResponse;
import com.sarvatra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> greeting() {
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
    }

}
