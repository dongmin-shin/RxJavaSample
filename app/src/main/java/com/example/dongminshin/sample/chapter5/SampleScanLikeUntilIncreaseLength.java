package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleScanLikeUntilIncreaseLength extends BaseExecutor {

    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        Observable.from(stringList).scan("defV", new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                System.out.println("s : " + s + ", s2 : " + s2);

                if (s.length() > s2.length()) {
                    return s;
                } else {
                    return s2;
                }
            }
        }).distinct().subscribe(new Subscriber<String>() {
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
