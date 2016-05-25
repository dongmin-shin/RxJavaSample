package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleFlatMapIterable extends BaseExecutor {

    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        Observable.from(stringList).flatMapIterable(new Func1<String, Iterable<String>>() {
            @Override
            public Iterable<String> call(String s) {
                System.out.println("call s : " + s);

                List<String> modifiedList = new ArrayList<String>();
                for (String item : stringList) {
                    modifiedList.add("call " + item);
                }

                return modifiedList;
            }
        }, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {   // s : new Func1()의 call에 넘겨진 파라메터, s2 : iterable로 생성 된 modified string
                String msg = "original : " + s + ", modified : " + s2;
                System.out.println(msg);
                return msg;
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {      // 파라메터는 new Func2()에서 가공 후 return 한 값
                System.out.println("onNext : " + s);
            }
        });
    }
}
