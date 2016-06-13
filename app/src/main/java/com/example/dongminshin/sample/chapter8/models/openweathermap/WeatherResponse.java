
package com.example.dongminshin.sample.chapter8.models.openweathermap;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponse {

    private City city;
    private int cod;
    private double message;
    private int cnt;
    private List<WeatherInfo> list;

    @Data
    public class City {
        private long id;
        private String name;
        private Coord coord;
        private String country;
        private int population;
    }

    @Data
    public class WeatherInfo {
        private int dt;
        private Main main;
        private List<Weather> weather;
        private Clouds clouds;
        private Wind wind;
        private Sys sys;
        private String dt_txt;
    }

}
