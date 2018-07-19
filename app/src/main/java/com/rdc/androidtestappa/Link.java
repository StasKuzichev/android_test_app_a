package com.rdc.androidtestappa;

import android.icu.util.LocaleData;

import java.time.LocalDate;

public class Link {
    private int id;
    private String url;
    private int status;
    private LocalDate date;
    Link(int id,String url,int status){
        this.id = id;
        this.url = url;
        this.status = status;
        //add a variable date
      //  LocalDate date = new LocalDate();
    }
}
