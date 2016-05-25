package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observer;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SamplePublishSubject extends BaseExecutor {
    @Override
    public void execute() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        Subscription subscription = publishSubject.subscribe(new Observer<String>() {
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
                System.out.println("Published item is : " + s);
            }
        });

        publishSubject.onNext("Hello Publish Subject");

        // onCompleted를 명시적으로 호출하지 않으면, 해당 Observable은 영원히 살아있게 된다.
        publishSubject.onCompleted();


    }
}
