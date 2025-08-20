package com.sarvatra.mode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("weather-descriptions")
    private List<String> weatherDescriptions;

    @JsonProperty("feel-like")
    private int feelsLike;  // corrected

}
