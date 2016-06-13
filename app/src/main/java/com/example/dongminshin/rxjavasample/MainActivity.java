package com.example.dongminshin.rxjavasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dongminshin.sample.chapter4.SampleDebounce;
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

        // OfType
//        SampleOfType sampleOfType = new SampleOfType();
//        sampleOfType.execute();

        // Take
//        SampleTake sampleTake = new SampleTake();
//        sampleTake.execute();

        // TakeLast
//        SampleTakeLast sampleTakeLast = new SampleTakeLast();
//        sampleTakeLast.execute();

        // Distinct
//        SampleDistinct sampleDistinct = new SampleDistinct();
//        sampleDistinct.execute();

        // Distinct with parameter
//        SampleDistinctParameter sampleDistinctParameter = new SampleDistinctParameter();
//        sampleDistinctParameter.execute();

        // DistinctUntilChanged
//        SampleDistinctUntilChanged sampleDistinctUntilChanged = new SampleDistinctUntilChanged();
//        sampleDistinctUntilChanged.execute();

        // First
//        SampleFirst sampleFirst = new SampleFirst();
//        sampleFirst.execute();

        // Last
//        SampleLast sampleLast = new SampleLast();
//        sampleLast.execute();

        // Skip
//        SampleSkip sampleSkip = new SampleSkip();
//        sampleSkip.execute();

        // SkipLast
//        SampleSkipLast sampleSkipLast = new SampleSkipLast();
//        sampleSkipLast.execute();

        // elementAt
//        SampleElementAt sampleElementAt = new SampleElementAt();
//        sampleElementAt.execute();

        // Sample
//        SampleSample sampleSample = new SampleSample();
//        sampleSample.execute();

        // Timeout
//        SampleTimeout sampleTimeout = new SampleTimeout();
//        sampleTimeout.execute();

        // Debounce
        SampleDebounce sampleDebounce = new SampleDebounce();
        sampleDebounce.execute();


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
