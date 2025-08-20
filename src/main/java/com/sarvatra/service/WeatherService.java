package com.sarvatra.service;

import com.sarvatra.mode.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            logger.info("Returning Response from Redis");
            return weatherResponse;
        } else {
            WeatherResponse weatherResponse1 = new WeatherResponse();
            weatherResponse1.setTemperature(25);
            weatherResponse1.setWeatherDescriptions(List.of("USA", "CHINA"));
            weatherResponse1.setFeelsLike(25);
            redisService.set("weather_of_" + city, weatherResponse1, 10000L);
            logger.info("Calling Weather API");
            return weatherResponse1;
        }

    }
}

