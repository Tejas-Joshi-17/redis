package com.sarvatra.controller;

import com.sarvatra.model.WeatherData;
import com.sarvatra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{cityName}")
    public ResponseEntity<?> getWeatherInformation(@PathVariable String cityName) {
        WeatherData weatherData = weatherService.getWeather(cityName);
        if (null != weatherData)
            return new ResponseEntity<>(weatherData, HttpStatus.OK);
        else {
            return new ResponseEntity<>("No Data Present", HttpStatus.OK);
        }
    }

    @PostMapping
    private ResponseEntity<String> updateWeatherInformation(@RequestBody WeatherData weatherData) {
        weatherService.updateWeather(weatherData);
        return new ResponseEntity<>("Data Updated Successfully", HttpStatus.OK);
    }

}
