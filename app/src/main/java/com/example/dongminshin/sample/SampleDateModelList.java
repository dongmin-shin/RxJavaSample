package com.example.dongminshin.sample;

import com.example.dongminshin.sample.model.DateModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.Getter;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDateModelList {

    @Getter
    private List<DateModel> sampleList;

    public SampleDateModelList() {
        initList();
    }

    private void initList() {
        sampleList = new ArrayList<>();

        sampleList.add(new DateModel("Dice", toDate(2016, 5, 1)));
        sampleList.add(new DateModel("Banana", toDate(2016, 5, 3)));
        sampleList.add(new DateModel("Melon", toDate(2016, 4, 1)));
        sampleList.add(new DateModel("City", toDate(2016, 5, 11)));
        sampleList.add(new DateModel("Bicycle", toDate(2016, 5, 11)));
        sampleList.add(new DateModel("Driving", toDate(2016, 5, 1)));
        sampleList.add(new DateModel("Car", toDate(2016, 2, 1)));
        sampleList.add(new DateModel("Indiana Johns", toDate(2016, 5, 3)));
        sampleList.add(new DateModel("SpiderMan", toDate(2016, 4, 1)));
        sampleList.add(new DateModel("Matrix", toDate(2016, 3, 21)));
        sampleList.add(new DateModel("Civil War", toDate(2016, 5, 1)));
    }

    private Date toDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }
}
