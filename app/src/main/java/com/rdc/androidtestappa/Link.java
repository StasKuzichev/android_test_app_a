package com.rdc.androidtestappa;

import java.util.Date;


public class Link {
    private int id;
    private String url;
    private int status;
    private Date date;

    Link(int id,String url,int status){
        this.id = id;
        this.url = url;
        this.status = status;
        this.date = new Date();
    }

    int getIdLink() {
        return id;
    }

    String getUrlLink() {
        return url;
    }

    int getStatusLink() {
        return status;
    }
    Date getDateLink(){
        return date;
    }
}
