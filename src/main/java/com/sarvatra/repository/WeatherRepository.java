package com.sarvatra.repository;

import com.sarvatra.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    Optional<WeatherData> findByCityName(String cityName);

}
