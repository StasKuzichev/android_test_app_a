package com.rdc.androidtestappa.utils;

import com.rdc.androidtestappa.Link;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<Link> {
    @Override
    public int compare(Link linkFirst , Link linkSecond) {
        return linkFirst.getDate().compareTo(linkSecond.getDate());
    }
}