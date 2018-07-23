package com.rdc.androidtestappa;

import android.graphics.Color;
import java.util.Date;

public class Link {
    private int id;
    private int status;
    private String url;
    private Date date;

    public Link(int id, String url, int status) {
        this.id = id;
        this.status = status;
        this.url = url;
        this.date = new Date();
    }

    public Link(int id, String url, int status, Date date) {
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
        int color = Color.parseColor("#FFFFFFFF");
        switch (this.status) {
            case 0:
                color = Color.parseColor("#6664DD17");
                break;
            case 1:
                color = Color.parseColor("#9DEF0407");
                break;
            case 2:
                color = Color.parseColor("#FF6C8996");
                break;
        }

        return color;
    }
}