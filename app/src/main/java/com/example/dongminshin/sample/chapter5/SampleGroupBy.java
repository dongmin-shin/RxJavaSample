package com.example.dongminshin.sample.chapter5;

import com.example.dongminshin.executor.BaseExecutor;
import com.example.dongminshin.sample.SampleDateModelList;
import com.example.dongminshin.sample.model.DateModel;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
public class SampleGroupBy extends BaseExecutor {

    @Override
    public void execute() {
        SampleDateModelList sampleDateModelList = new SampleDateModelList();
        List<DateModel> dateModelList = sampleDateModelList.getSampleList();

        // 이름으로 정렬한 뒤,
        Collections.sort(dateModelList);

        // 날짜별로 Grouping
        Observable<GroupedObservable<String, DateModel>> groupedItems
                = Observable.from(dateModelList).groupBy(new Func1<DateModel, String>() {
            @Override
            public String call(DateModel dateModel) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                return formatter.format(dateModel.getDate());
            }
        });

        Observable.concat(groupedItems).subscribe(new Subscriber<DateModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DateModel dateModel) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                System.out.println("onNext : " + dateModel.getName() + ", Date : " + formatter.format(dateModel.getDate()));
            }
        });
    }
}
