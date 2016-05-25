package com.example.dongminshin.sample.chapter4;

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
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext : " + s);
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
