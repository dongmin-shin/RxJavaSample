package com.example.dongminshin.sample.chapter4;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleTakeLast extends BaseExecutor {
    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> sampleList = sampleStringList.getSampleList();

        Observable.from(sampleList).takeLast(2).subscribe(new Observer<String>() {
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
