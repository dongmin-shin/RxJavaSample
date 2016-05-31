package com.example.dongminshin.rxjavasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.dongminshin.sample.chapter8.SampleApiManager;
import com.example.dongminshin.sample.chapter8.models.User;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.test_btn)
    public void onClickTest(View v) {
        SampleApiManager.getInstance().getMostPopularSOusers(10)
        .subscribe(new Observer<List<User>>() {
            @Override
            public void onCompleted() {
                Log.d("TEST", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TEST", "onError", e);
            }

            @Override
            public void onNext(List<User> users) {
                Log.d("TEST", "onNext");

                for (User user : users) {
                    Log.d("TEST", "users : " + user.getDisplayName());
                }
            }
        });

    }

}
