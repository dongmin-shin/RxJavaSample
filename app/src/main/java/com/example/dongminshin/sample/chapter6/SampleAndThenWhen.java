package com.example.dongminshin.sample.chapter6;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.joins.Pattern2;
import rx.joins.Plan0;
import rx.observables.JoinObservable;

/**
 * Created by DongMinShin on 16. 5. 24..
 */
public class SampleAndThenWhen extends BaseExecutor {

    @Override
    public void execute() {

        List<String> stringList = new SampleStringList().getSampleList();

        Observable<String> stringObservable = Observable.interval(2, TimeUnit.SECONDS).from(stringList);
        Observable<Long> ticObservable = Observable.interval(1500, TimeUnit.MILLISECONDS);

        Pattern2<String, Long> pattern = JoinObservable.from(stringObservable).and(ticObservable);
        Plan0<String> plan = pattern.then(new Func2<String, Long, String>() {
            @Override
            public String call(String s, Long aLong) {
                return s + "(" + aLong + ")";
            }
        });

        JoinObservable
                .when(plan)
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
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
