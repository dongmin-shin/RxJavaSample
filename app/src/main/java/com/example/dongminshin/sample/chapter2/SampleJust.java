package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleJust extends BaseExecutor {
    @Override
    public void execute() {

        Observable<String> observable = Observable.just(getHelloWorld());
        Subscription subscription = observable.subscribe(new Observer<String>() {
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

    }

    private String getHelloWorld() {
        return "Hello World";
    }
}
