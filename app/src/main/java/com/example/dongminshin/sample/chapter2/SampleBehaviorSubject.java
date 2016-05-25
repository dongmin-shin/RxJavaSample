package com.example.dongminshin.sample.chapter2;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observer;
import rx.subjects.BehaviorSubject;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleBehaviorSubject extends BaseExecutor {
    @Override
    public void execute() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext("Behavior Subject 1");
        behaviorSubject.onNext("Behavior Subject 2");
        behaviorSubject.onNext("Behavior Subject 3");

        behaviorSubject.subscribe(new Observer<String>() {
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
                System.out.println("Published item is : " + s);
            }
        });

        behaviorSubject.onNext("Behavior Subject 4");
        behaviorSubject.onNext("Behavior Subject 5");


        // onCompleted를 명시적으로 호출하지 않으면, 해당 Observable은 영원히 살아있게 된다.
        behaviorSubject.onCompleted();
    }
}
