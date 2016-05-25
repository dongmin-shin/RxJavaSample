package com.example.dongminshin.sample;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Created by DongMinShin on 16. 5. 22..
 */
public class SampleStringList {

    @Getter
    private List<String> sampleList;

    public SampleStringList() {
        initList();
    }

    private void initList() {
        sampleList = new ArrayList<>();
        sampleList.add("Dice");
        sampleList.add("Apple");
        sampleList.add("Banana");
        sampleList.add("Melon");
        sampleList.add("City");
        sampleList.add("Bicycle");
        sampleList.add("Driving");
        sampleList.add("Car");
        sampleList.add("Indiana Johns");
        sampleList.add("SpiderMan");
        sampleList.add("Matrix");
        sampleList.add("Civil War");
    }

}
