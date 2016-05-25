package com.example.dongminshin.sample.chapter4;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleStringList;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleElementAt extends BaseExecutor {

    @Override
    public void execute() {
        SampleStringList sampleStringList = new SampleStringList();
        List<String> stringList = sampleStringList.getSampleList();

        /*
         만약에 elementAt(30).elementAtOrDefault(50, "none") 이런 식으로 호출하게 되면,
         elementAt(30) 먼저 호출하고 종료하게 된다. 왜냐하면 해당 Observable은 한 번만 아이템을 발행하기 때문이다.
          */

        Observable.from(stringList).elementAt(5).subscribe(new Subscriber<String>() {
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
