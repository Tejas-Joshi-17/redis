package com.sarvatra.service;

import com.sarvatra.model.WeatherData;
import com.sarvatra.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherData getWeather(String city) {
        WeatherData weatherData = redisService.get(city, WeatherData.class);
        if (weatherData != null) {
            logger.info("Returning Response from Redis");
            return weatherData;
        }else {
            Optional<WeatherData> weatherData1 = weatherRepository.findByCityName(city);
            if (weatherData1.isPresent()) {
                WeatherData cityWeatherData = weatherData1.get();
                redisService.set(cityWeatherData.getCityName(), cityWeatherData, -1L);
                return redisService.get(city, WeatherData.class);
            } else {
                logger.info("No Data Found in Database");
            }
            return null;
        }

    }

    public WeatherData updateWeather(WeatherData weatherData) {
        weatherRepository.save(weatherData);
        logger.info("Update Data in Database");
        redisService.set(weatherData.getCityName(), weatherData, -1L);  // -1 for no-timeout
        return weatherData;
    }
}

