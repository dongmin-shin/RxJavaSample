package com.example.dongminshin.sample.chapter4;

import android.util.Log;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleDuplicatedList;

import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDistinct extends BaseExecutor {
    @Override
    public void execute() {
        SampleDuplicatedList sampleDuplicatedList = new SampleDuplicatedList();
        List<String> duplicatedList = sampleDuplicatedList.getSampleList();

        Observable.from(duplicatedList).distinct().subscribe(new Observer<String>() {
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
