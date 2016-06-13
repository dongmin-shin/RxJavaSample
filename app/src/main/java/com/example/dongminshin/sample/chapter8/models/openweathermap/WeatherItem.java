package com.example.dongminshin.sample.chapter8.models.openweathermap;

import org.joda.time.DateTime;

import lombok.Data;

/**
 * Created by DongMinShin on 16. 6. 5..
 */
@Data
public class WeatherItem {

    public WeatherItem(DateTime dateTime, String temperature) {
        this.dateTime = dateTime;
        this.temperature = temperature;
    }

    private DateTime dateTime;
    private String temperature;

}
