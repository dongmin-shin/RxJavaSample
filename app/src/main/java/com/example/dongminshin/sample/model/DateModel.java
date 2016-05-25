package com.example.dongminshin.sample.model;

import java.util.Date;

import lombok.Data;

/**
 * Created by DongMinShin on 16. 5. 23..
 */
@Data
public class DateModel implements Comparable<DateModel> {
    private String name;
    private Date date;

    public DateModel(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(DateModel another) {
        return getName().compareTo(another.getName());
    }
}
