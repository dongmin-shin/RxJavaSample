//package com.example.dongminshin.sample.chapter8.ui;
//
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.dongminshin.rxjavasample.R;
//import com.example.dongminshin.sample.chapter8.OpenWeatherMapAPIManager;
//import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherResponse;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
//import com.nostra13.universalimageloader.core.assist.FailReason;
//import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import rx.Observable;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;
//
///**
// * Created by DongMinShin on 16. 6. 4..
// */
//public class OldOpenWeatherMapActivity extends AppCompatActivity {
//
//    @BindView(R.id.weather_icon)
//    ImageView weatherIcon;
//
//    @BindView(R.id.weather_city)
//    TextView city;
//
//    @BindView(R.id.weather_temperature)
//    TextView temperature;
//
//    @BindView(R.id.weather_wind_speed)
//    TextView windSpeed;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_open_weather_map);
//        ButterKnife.bind(this);
//
//        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
//
//        String engCityName = "Seoul";
//
//        OpenWeatherMapAPIManager.getInstance().getForecastByCity(engCityName)
//                .filter(new Func1<WeatherResponse, Boolean>() {
//                    @Override
//                    public Boolean call(WeatherResponse weatherResponse) {
//                        return weatherResponse != null;
//                    }
//                })
//                .filter(new Func1<WeatherResponse, Boolean>() {
//                    @Override
//                    public Boolean call(WeatherResponse weatherResponse) {
//                        return weatherResponse.getWeather() != null && weatherResponse.getWeather().size() > 0;
//                    }
//                })
//                .flatMap(new Func1<WeatherResponse, Observable<Bitmap>>() {
//                    @Override
//                    public Observable<Bitmap> call(WeatherResponse weatherResponse) {
//                        String weatherIconUrl = getWeatherIconUrl(weatherResponse);
//
//                        city.setText(weatherResponse.getName());
//                        temperature.setText(String.valueOf(weatherResponse.getMain().getTemp()));
//                        windSpeed.setText(String.valueOf(weatherResponse.getWind().getSpeed()));
//
//                        return Observable.create(new Observable.OnSubscribe<Bitmap>() {
//                            @Override
//                            public void call(Subscriber<? super Bitmap> subscriber) {
//                                ImageLoader.getInstance().displayImage(weatherIconUrl, weatherIcon, new ImageLoadingListener() {
//                                    @Override
//                                    public void onLoadingStarted(String imageUri, View view) {
//                                        Log.d("TEST", "onLoadingStarted");
//                                    }
//
//                                    @Override
//                                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                                        Log.d("TEST", "onLoadingFailed");
//                                        subscriber.onError(failReason.getCause());
//                                    }
//
//                                    @Override
//                                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                                        Log.d("TEST", "onLoadingComplete");
//                                        subscriber.onNext(loadedImage);
//                                        subscriber.onCompleted();
//                                    }
//
//                                    @Override
//                                    public void onLoadingCancelled(String imageUri, View view) {
//                                        Log.d("TEST", "onLoadingCancelled");
//                                    }
//                                });
//                            }
//                        });
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Bitmap>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("TEST", "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("TEST", "onError", e);
//                    }
//
//                    @Override
//                    public void onNext(Bitmap bitmap) {
//                        Log.d("TEST", "onNext");
//                        weatherIcon.setImageBitmap(bitmap);
//                    }
//                });
//    }
//
//    private String getWeatherIconUrl(WeatherResponse weatherResponse) {
//        return "http://openweathermap.org/img/w/" + weatherResponse.getWeather().get(0).getIcon() + ".png";
//    }
//}
