package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleCreate extends BaseExecutor {

    @Override
    public void execute() {
        Observable<Integer> observableString = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0; i < 5; i++) {
                    subscriber.onNext(i);
                }

                subscriber.onCompleted();
            }
        });

        Subscription subscriptionPrint = observableString.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error : " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("item id : " + integer);
            }
        });
    }
}
