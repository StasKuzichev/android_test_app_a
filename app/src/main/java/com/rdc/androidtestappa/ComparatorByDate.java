package com.rdc.androidtestappa;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;

public class ComparatorByDate implements Comparator {							//сортировка по дате/времени
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int compare(Object o1, Object o2) {
        return ((Link)o1).GetDate().compareTo(((Link)o2).GetDate());
    }
}