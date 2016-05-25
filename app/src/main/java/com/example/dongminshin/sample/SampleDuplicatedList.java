package com.example.dongminshin.sample;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleDuplicatedList {

    @Getter
    private List<String> sampleList;

    public SampleDuplicatedList() {
        initList();
    }

    private void initList() {
        sampleList = new ArrayList<>();
        sampleList.add("Dice");
        sampleList.add("SpiderMan");
        sampleList.add("Matrix");
        sampleList.add("Apple");
        sampleList.add("Banana");
        sampleList.add("Melon");
        sampleList.add("Dice");
        sampleList.add("City");
        sampleList.add("Bicycle");
        sampleList.add("Driving");
        sampleList.add("Indiana Johns");
        sampleList.add("SpiderMan");
        sampleList.add("Matrix");
        sampleList.add("Indiana Johns");
        sampleList.add("Civil War");
        sampleList.add("Banana");
        sampleList.add("Melon");
        sampleList.add("City");
        sampleList.add("Bicycle");
        sampleList.add("Car");
        sampleList.add("Indiana Johns");
        sampleList.add("SpiderMan");
        sampleList.add("Matrix");
        sampleList.add("Indiana Johns");
        sampleList.add("Civil War");
    }

}
