package com.example.dongminshin.sample.chapter3;

import android.content.Context;
import android.widget.Toast;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Observer;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleRange extends BaseExecutor {

    @Override
    public void execute() {

    }

    @Override
    public void execute(Context context) {
        super.execute(context);

        Observable
                .range(10, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError : " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                        Toast.makeText(context, "onNext : " + integer, Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
