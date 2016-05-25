package com.example.dongminshin.sample.chapter6;

import android.content.Context;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;

/**
 * Created by DongMinShin on 16. 5. 24..
 */
public class SampleZip extends BaseExecutor {
    @Override
    public void execute(Context context) {
        List<String> stringList = new SampleStringList().getSampleList();

        Observable<String> stringObservable = Observable.from(stringList);
        Observable<Long> ticObservable = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(stringObservable, ticObservable, new Func2<String, Long, String>() {
            @Override
            public String call(String s, Long aLong) {
                return s + "(" + aLong + ")";
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
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
                        // Toast를 사용할 때는 observerOn을 통해 반드시 UI 갱신을 위해 MainThread를 갖고 오도록 하자.
//                        Toast.makeText(context, "onNext : " + s, Toast.LENGTH_SHORT).show();
                        System.out.println("onNext : " + s);
                    }
                });

    }

    @Override
    public void execute() {

    }
}
