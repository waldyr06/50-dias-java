package com.semana_4.climape.model;

import lombok.Data;

@Data
public class RespostaOpenMeteo {
    @Data
    public static class CurrentWeather {
        private Double temperature;
        private Integer weathercode;

    }

    private CurrentWeather current_weather;
}