package com.example.dongminshin.rxjavasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dongminshin.sample.chapter8.ui.StackExchangeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.test_btn)
    public void onClickTest(View v) {
        Intent stackExchangeIntent = new Intent(this, StackExchangeActivity.class);
        startActivity(stackExchangeIntent);
    }

}
