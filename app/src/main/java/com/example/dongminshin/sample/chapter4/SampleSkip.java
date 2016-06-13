package com.example.dongminshin.sample.chapter4;

import android.util.Log;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleSkip extends BaseExecutor {

    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        Observable.from(stringList).skip(2).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("TEST", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TEST", "onError", e);
            }

            @Override
            public void onNext(String s) {
                Log.d("TEST", "onNext : " + s);
            }
        });
    }
}
