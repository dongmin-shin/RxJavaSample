package com.example.dongminshin.sample.chapter6;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by DongMinShin on 16. 5. 24..
 */
public class SampleCombineLatest extends BaseExecutor {

    @Override
    public void execute() {

        List<String> stringList = new SampleStringList().getSampleList();

        Observable<String> stringObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        int position = aLong.intValue();
                        return stringList.get(position);
                    }
                });

        Observable<Long> ticObservable = Observable.interval(1500, TimeUnit.MILLISECONDS);

        Observable.combineLatest(stringObservable, ticObservable, new Func2<String, Long, String>() {
            @Override
            public String call(String s, Long aLong) {
                return s + "(" + aLong + ")";
            }
        }).subscribe(new Subscriber<String>() {
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
    }
}
