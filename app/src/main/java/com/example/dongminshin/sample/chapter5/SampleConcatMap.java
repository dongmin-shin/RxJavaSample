package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleConcatMap extends BaseExecutor {

    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        Observable.from(stringList).concatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just("first : " + s.toLowerCase(), "second : " + s.toUpperCase());
            }
        }).subscribe(new Observer<String>() {
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
