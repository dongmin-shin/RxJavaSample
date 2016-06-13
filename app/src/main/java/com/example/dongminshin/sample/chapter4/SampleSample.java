package com.example.dongminshin.sample.chapter4;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import com.example.dongminshin.executor.BaseExecutor;

import java.util.concurrent.TimeUnit;

import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleSample extends BaseExecutor {

    private class TestAsyncClass extends AsyncTask<Void, Void, Void> {

        PublishSubject publishSubject;

        public TestAsyncClass(PublishSubject publishSubject) {
            this.publishSubject = publishSubject;
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i = 0;
            while (i < 10) {
                Log.d("TEST", "send value is " + i);
                publishSubject.onNext("value is " + i);
                i += 1;
                SystemClock.sleep(1 * 1000);
            }

            publishSubject.onCompleted();
            return null;
        }
    }

    @Override
    public void execute() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject
                .sample(3, TimeUnit.SECONDS)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d("TEST", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TEST", "onError", e);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("TEST", "onNext : " + s);
                    }
                });

        TestAsyncClass testAsyncClass = new TestAsyncClass(publishSubject);
        testAsyncClass.execute();

    }

}
