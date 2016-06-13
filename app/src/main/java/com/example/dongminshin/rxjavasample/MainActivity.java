package com.example.dongminshin.rxjavasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dongminshin.sample.chapter3.SampleTimer;
import com.example.dongminshin.sample.chapter8.ui.OpenWeatherMapActivity;
import com.example.dongminshin.sample.chapter8.ui.StackExchangeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SampleTimer sampleTimer = new SampleTimer();
        sampleTimer.execute(this);

    }

    @OnClick(R.id.stack_exchange)
    public void onClickStackExchange(View v) {
        Intent stackExchangeIntent = new Intent(this, StackExchangeActivity.class);
        startActivity(stackExchangeIntent);
    }

    @OnClick(R.id.open_weather_map)
    public void onClickOpenWeatherMap(View v) {
        Intent openWeatherMapIntent = new Intent(this, OpenWeatherMapActivity.class);
        startActivity(openWeatherMapIntent);
    }

}
