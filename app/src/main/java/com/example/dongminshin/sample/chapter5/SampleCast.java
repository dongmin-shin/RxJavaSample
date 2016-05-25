package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 23..
 */

/**
 * Cast를 정확하게 테스트 해볼 수 있는 로직이 필요하다.
 */
public class SampleCast extends BaseExecutor {
    @Override
    public void execute() {
        Observable.just("Hello World").cast(String.class).subscribe(new Subscriber<String>() {
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
