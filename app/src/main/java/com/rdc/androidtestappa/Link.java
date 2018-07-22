package com.rdc.androidtestappa;

import android.graphics.Color;
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

    Link(int id, String url, int status, Date date) {
        this.id = id;
        this.status = status;
        this.url = url;
        this.date = date;
    }

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

    public int getStatusColor() {
        int color = Color.parseColor("white");
        switch (this.status) {
            case 0:
                color = Color.parseColor("green");
                break;
            case 1:
                color = Color.parseColor("red");
                break;
            case 2:
                color = Color.parseColor("grey");
                break;
        }

        return color;
    }
}