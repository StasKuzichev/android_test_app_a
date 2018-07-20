package com.rdc.androidtestappa;

import java.util.Comparator;

public class ComparatorByDate implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Link) o1).getDate().compareTo(((Link) o2).getDate());
    }
}