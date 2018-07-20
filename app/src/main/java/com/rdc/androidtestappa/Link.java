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

    public int getIdLink() {
        return this.id;
    }

    public String getUrlLink() {
        return this.url;
    }

    public int getStatusLink() {
        return this.status;
    }
    public Date getDateLink(){
        return this.date;
    }
}
