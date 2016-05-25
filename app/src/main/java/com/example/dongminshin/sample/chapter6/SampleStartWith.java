package com.example.dongminshin.sample.chapter6;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by DongMinShin on 16. 5. 24..
 */
public class SampleStartWith extends BaseExecutor {

    @Override
    public void execute() {
        List<String> stringList = new SampleStringList().getSampleList();

        Observable<String> stringObservable = Observable.from(stringList);
        stringObservable
                .startWith("A", "B", "C")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("call : " + s);
                    }
                });
    }
}
