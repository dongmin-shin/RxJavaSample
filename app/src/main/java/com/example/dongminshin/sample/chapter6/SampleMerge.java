package com.example.dongminshin.sample.chapter6;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 24..
 */
public class SampleMerge extends BaseExecutor {

    @Override
    public void execute() {

        // Original List
        List<String> originalList = new SampleStringList().getSampleList();

        // Reversed List
        List<String> reverseList = new SampleStringList().getSampleList();
        Collections.reverse(reverseList);

        Observable<String> originalObservable = Observable.from(originalList);
        Observable<String> reversedObservable = Observable.from(reverseList);

        // Merge Observable
        Observable<String> mergedObservable = Observable.merge(originalObservable, reversedObservable);

        // Subscription
        mergedObservable.subscribe(new Subscriber<String>() {
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
