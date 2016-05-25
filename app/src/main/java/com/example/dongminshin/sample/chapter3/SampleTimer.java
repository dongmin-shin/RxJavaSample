package com.example.dongminshin.sample.chapter3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.dongminshin.executor.BaseExecutor;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleTimer extends BaseExecutor {
    @Override
    public void execute() {

    }

    @Override
    public void execute(Context context) {
        super.execute(context);

        // 3초 뒤에 수행
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError : " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("onNext : " + aLong);

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "onNext : " + aLong, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }
}
