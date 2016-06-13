package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleFrom extends BaseExecutor {
    @Override
    public void execute() {

        List<Integer> item = new ArrayList<>();
        item.add(100);
        item.add(10);
        item.add(40);
        item.add(5);
        item.add(300);
        item.add(200);

        Observable<Integer> observable = Observable.from(item);
        Subscription subscription = observable.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Item is : " + integer);
            }
        });
    }

}
