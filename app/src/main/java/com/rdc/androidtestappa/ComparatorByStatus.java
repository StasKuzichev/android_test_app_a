package com.rdc.androidtestappa;

import java.util.Comparator;

public class ComparatorByStatus implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Link) o1).getStatus() - ((Link) o2).getStatus();
    }
}
