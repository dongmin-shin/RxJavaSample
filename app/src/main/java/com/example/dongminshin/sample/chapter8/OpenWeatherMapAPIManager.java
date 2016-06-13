package com.example.dongminshin.sample.chapter8;

import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DongMinShin on 16. 6. 1..
 */
public class OpenWeatherMapAPIManager {

    public static final String HTTPS_API_OPEN_WEATHER_MAP_URL = "http://api.openweathermap.org";
    private final String API_KEY = "49c0f4d53c06fa158d6f8ffa18765695";

    private static OpenWeatherMapAPIManager INSTANCE;

    private final OpenWeatherMapAPI openWeatherMapAPI;

    private OpenWeatherMapAPIManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_API_OPEN_WEATHER_MAP_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        openWeatherMapAPI = retrofit.create(OpenWeatherMapAPI.class);
    }

    public static OpenWeatherMapAPIManager getInstance() {
        if (INSTANCE == null) {
            return new OpenWeatherMapAPIManager();
        }

        return INSTANCE;
    }

    public Observable<WeatherResponse> getForecastByCity(String city) {
        return openWeatherMapAPI.getForecastByCity(city, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
