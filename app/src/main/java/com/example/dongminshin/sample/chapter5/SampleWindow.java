package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleWindow extends BaseExecutor {
    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        Observable.from(stringList).window(3).subscribe(new Subscriber<Observable<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Observable<String> stringObservable) {
                System.out.println("[First] onNext");

                stringObservable.subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("[second] onNext : " + s);
                    }
                });
            }
        });
    }
}
