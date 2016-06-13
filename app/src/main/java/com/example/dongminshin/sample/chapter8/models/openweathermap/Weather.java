package com.example.dongminshin.sample.chapter8.models.openweathermap;

import lombok.Data;

/**
 * Created by DongMinShin on 16. 6. 5..
 */
@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
