package com.rdc.androidtestappa;

import java.util.Date;

public class Link {
    private int id;
    private int status;
    private String url;
    private Date date;


    Link(int id, String url, int status) {
        this.id = id;
        this.status = status;
        this.url = url;
        this.date = new Date();
    }

//    public String toString() {
//        return "\n" + this.id + " " + this.url + " " + this.status + " " + this.date;
//    }

    public int getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public Date getDate() {
        return this.date;
    }
}