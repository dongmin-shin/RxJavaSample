package com.example.dongminshin.sample.chapter4;

import android.os.AsyncTask;

import com.example.dongminshin.executor.BaseExecutor;

import java.util.concurrent.TimeUnit;

import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleTimeout extends BaseExecutor {

    private class TestAsyncClass extends AsyncTask<Void, Void, Void> {

        PublishSubject publishSubject;

        public TestAsyncClass(PublishSubject publishSubject) {
            this.publishSubject = publishSubject;
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i=0;
            while (i < 5) {
                System.out.println("send value is " + i);
                publishSubject.onNext("value is " + i);
                try {
                    i += 1;
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    break;
                }
            }

            publishSubject.onCompleted();
            return null;
        }
    }

    @Override
    public void execute() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject
                .timeout(2, TimeUnit.SECONDS)
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
                        System.out.println("onNext : " + s);
                    }
                });

        TestAsyncClass testAsyncClass = new TestAsyncClass(publishSubject);
        testAsyncClass.execute();

    }

}
