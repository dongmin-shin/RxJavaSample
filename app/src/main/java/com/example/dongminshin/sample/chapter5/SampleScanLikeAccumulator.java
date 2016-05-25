package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleScanLikeAccumulator extends BaseExecutor {

    @Override
    public void execute() {
        // 단순 누산기 형태로 동작 하는 구조
        Observable.just(1, 2, 3, 4, 5).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(new Subscriber<Integer>() {
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
                System.out.println("onNext : " + integer);
            }
        });
    }
}
