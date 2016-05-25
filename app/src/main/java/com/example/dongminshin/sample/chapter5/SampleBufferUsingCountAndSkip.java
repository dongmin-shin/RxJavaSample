package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleBufferUsingCountAndSkip extends BaseExecutor {
    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        int count = 2;
        int skip = 3;
        Observable.from(stringList).buffer(count, skip).subscribe(new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : " + e.getMessage());
            }

            @Override
            public void onNext(List<String> strings) {
                System.out.println("onNext");

                for (String item : strings) {
                    System.out.println("published item is " + item);
                }
            }
        });
    }
}
