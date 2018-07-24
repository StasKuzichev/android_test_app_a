package com.rdc.androidtestappa.utils;

import com.rdc.androidtestappa.Link;

import java.util.Comparator;

public class ComparatorByStatus implements Comparator<Link> {
    public int compare(Link o1, Link o2) {
        return o1.getStatus() - o2.getStatus();
    }
}
