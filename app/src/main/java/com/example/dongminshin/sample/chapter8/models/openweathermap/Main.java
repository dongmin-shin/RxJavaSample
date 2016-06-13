package com.example.dongminshin.sample.chapter8.models.openweathermap;

import lombok.Data;

/**
 * Created by DongMinShin on 16. 6. 5..
 */
@Data
public class Main {
    private double temp;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double sea_level;
    private double grnd_level;
    private int humidity;
    private double temp_kf;
}
