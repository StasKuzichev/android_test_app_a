package com.rdc.androidtestappa.utils;

import com.rdc.androidtestappa.Link;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparatorByDate implements Comparator<Link> {
    @Override
    public int compare(Link linkFirst , Link linkSecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
        try {
            Date dateOne = simpleDateFormat.parse(linkFirst.getDate());
            Date dateTwo = simpleDateFormat.parse(linkSecond.getDate());
            return dateTwo.compareTo(dateOne);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}