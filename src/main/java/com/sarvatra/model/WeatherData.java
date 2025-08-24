package com.sarvatra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "weather")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @JsonProperty("city-name")
    private String cityName;

    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("feel-like")
    private int feelsLike;

}