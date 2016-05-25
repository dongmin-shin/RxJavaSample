package com.example.dongminshin.sample.chapter3;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDeferred extends BaseExecutor {

    @Override
    public void execute() {
        Observable<Integer> deferred = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return getInt();
            }
        });

        deferred.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("integer : " + integer);
            }
        });
    }

    private Observable<Integer> getInt() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                System.out.println("call");
                subscriber.onNext(42);
                subscriber.onCompleted();
            }
        });
    }

}
