package com.example.dongminshin.sample.chapter8;

import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DongMinShin on 16. 6. 4..
 */
public interface OpenWeatherMapAPI {

    @GET("/data/2.5/forecast")
    Observable<WeatherResponse> getForecastByCity(
            @Query("q") String city,
            @Query("appid") String apiKey);
}
