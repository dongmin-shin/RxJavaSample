package com.example.dongminshin.sample.chapter5;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.example.dongminshin.executor.BaseExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Created by DongMinShin on 16. 5. 23..
 */

/**
 * 해당 클래스가 정상적으로 테스트가 되지 않는다.
 * SwitchMap의 경우,
 * TaskA 작업이 1, 2번 있고 2번 처리하는데 시간이 5초 이상 소요 된다고 가정한다면,
 * 연달아 실행 된 TaskB 작업이 존재하게 되는 경우, TaskA 작업의 2번이 cancel 되고 TaskB의 작업이 실행돼야 한다.
 * 근데, 해당 Sequence가 Merge(flatMap) 되서 실행되는게 좀 이상하다.
 */
@Deprecated
public class SampleSwitchMap extends BaseExecutor {
    @Override
    public void execute() {
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.switchMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s.toUpperCase());
            }
        }).subscribe(new Subscriber<String>() {
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

        publishSubject.onNext("Tiger");
        publishSubject.onNext("Lion");

        TestAsync testAsyncTag = new TestAsync("TagA", 2);
        testAsyncTag.execute(publishSubject);

        publishSubject.onNext("Horse");
        publishSubject.onNext("Pizza");

        SystemClock.sleep(2 * 1000);

        publishSubject.onNext("TestA");

        SystemClock.sleep(3 * 1000);

        publishSubject.onNext("TestB");

        SystemClock.sleep(1 * 1000);

        publishSubject.onNext("TestC");

        SystemClock.sleep(2 * 1000);

        publishSubject.onNext("TestD");

    }

    private class TestAsync extends AsyncTask<PublishSubject<String>, Void, Void> {

        private String tag;
        private int delay;

        public TestAsync(String tag, int delay) {
            this.tag = tag;
            this.delay = delay;
        }

        @Override
        protected Void doInBackground(PublishSubject<String>... params) {
            PublishSubject<String> publishSubject = params[0];

            int i=0;
            while (i < 5) {
                publishSubject.onNext("[" + tag + "] : Value is " + i);
                i += 1;
                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException e) {
                }
            }

            return null;
        }
    }
}
