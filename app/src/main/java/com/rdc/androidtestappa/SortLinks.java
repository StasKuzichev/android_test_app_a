package com.rdc.androidtestappa;

import java.util.ArrayList;
import java.util.Arrays;

public class SortLinks {
    public ArrayList<Link> linksArrayList = new ArrayList<>();
    SortLinks(ArrayList<Link> linksal, boolean sort_switch){
        Link[] links = new Link[linksal.size()];
        links = linksal.toArray(links);
        if(sort_switch){
            Arrays.sort(links, new ComparatorByDate());
        }else{
            Arrays.sort(links, new ComparatorByStatus());
        }
        for (Link link:links) {
           linksArrayList.add(link);
        }
    }
}
