package com.example.dongminshin.sample.chapter4;

import android.util.Log;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDistinctUntilChanged extends BaseExecutor {
    @Override
    public void execute() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.distinctUntilChanged().subscribe(new Subscriber<String>() {
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

        publishSubject.onNext("a");
        publishSubject.onNext("a");
        publishSubject.onNext("a");
        publishSubject.onNext("b");
        publishSubject.onNext("b");
        publishSubject.onNext("a");
        publishSubject.onNext("a");
        publishSubject.onNext("c");
        publishSubject.onNext("a");
        publishSubject.onNext("b");
        publishSubject.onNext("c");
    }
}
