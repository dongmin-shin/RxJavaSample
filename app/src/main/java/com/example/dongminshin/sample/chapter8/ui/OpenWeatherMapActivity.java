package com.example.dongminshin.sample.chapter8.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dongminshin.rxjavasample.R;
import com.example.dongminshin.sample.chapter8.OpenWeatherMapAPIManager;
import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherItem;
import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherResponse;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by DongMinShin on 16. 6. 4..
 */
public class OpenWeatherMapActivity extends AppCompatActivity {

    @BindView(R.id.open_weather_recycler_view)
    RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private OpenWeatherMapAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_weather_map);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new OpenWeatherMapAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

//        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
//
        String engCityName = "Seoul";

        OpenWeatherMapAPIManager.getInstance().getForecastByCity(engCityName)
                .filter(new Func1<WeatherResponse, Boolean>() {
                    @Override
                    public Boolean call(WeatherResponse weatherResponse) {
                        return weatherResponse.getList() == null || weatherResponse.getList().isEmpty();
                    }
                })
                .flatMap(new Func1<WeatherResponse, Observable<List<WeatherItem>>>() {
                    @Override
                    public Observable<List<WeatherItem>> call(WeatherResponse weatherResponse) {
                        return Observable.create(new Observable.OnSubscribe<List<WeatherItem>>() {
                            @Override
                            public void call(Subscriber<? super List<WeatherItem>> subscriber) {
                                List<WeatherItem> weatherItemList = new ArrayList<WeatherItem>();

                                List<WeatherResponse.WeatherInfo> weatherInfoList = weatherResponse.getList();
                                for (WeatherResponse.WeatherInfo weatherInfo : weatherInfoList) {

                                    DateTime dateTime = new DateTime(weatherInfo.getDt_txt());
                                    String temperature = String.valueOf(weatherInfo.getMain().getTemp());

                                    WeatherItem weatherItem = new WeatherItem(dateTime, temperature);
                                    weatherItemList.add(weatherItem);
                                }

                                subscriber.onNext(weatherItemList);
                            }
                        });
                    }
                }).subscribe(new Subscriber<List<WeatherItem>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<WeatherItem> weatherItems) {
                adapter.updateWeatherInfoList(weatherItems);
            }
        });

    }
}
