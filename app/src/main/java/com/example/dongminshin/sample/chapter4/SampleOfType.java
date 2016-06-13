package com.example.dongminshin.sample.chapter4;

import android.util.Log;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleOfType extends BaseExecutor {
    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> sampleList = sampleStringList.getSampleList();

        List<Object> sampleTypeList = new ArrayList<>(sampleList);
        sampleTypeList.add(new Integer(10));
        sampleTypeList.add(new Integer(3));
        sampleTypeList.add(new Integer(20));
        sampleTypeList.add(new Integer(50));

        Observable.from(sampleTypeList).ofType(Integer.class).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                Log.d("TEST", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TEST", "onError", e);
            }

            @Override
            public void onNext(Object o) {
                Log.d("TEST", "onNext : " + o);
            }
        });
    }
}
