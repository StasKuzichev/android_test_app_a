package com.rdc.androidtestappa.utils;

import com.rdc.androidtestappa.Link;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<Link> {
    @Override
    public int compare(Link link , Link t1) {
        return link.getDate().compareTo(t1.getDate());
    }
}