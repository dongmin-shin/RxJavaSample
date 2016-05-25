package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDoOnCompleted extends BaseExecutor {

    @Override
    public void execute() {
        final PublishSubject<Boolean> publishSubject = PublishSubject.create();
        publishSubject.subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                System.out.println("Observable onNext is : " + aBoolean);
            }
        });

        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0; i < 5; i++) {
                    subscriber.onNext(i);   // 아이템을 발행
                }

                subscriber.onCompleted();
            }
        }).doOnCompleted(new Action0() {
            @Override
            public void call() {
                publishSubject.onNext(true);
            }
        });

        Subscription subscription = observable.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscription onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Published item is : " + integer);
            }
        });
    }


}
