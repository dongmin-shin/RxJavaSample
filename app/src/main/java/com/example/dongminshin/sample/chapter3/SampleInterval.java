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
public class SampleInterval extends BaseExecutor {

    @Override
    public void execute() {
    }

    @Override
    public void execute(Context context) {
        super.execute(context);

        Observable
                .interval(3, TimeUnit.SECONDS)
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
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "onNext interval : " + aLong, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

    }
}
