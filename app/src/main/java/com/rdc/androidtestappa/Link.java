package com.rdc.androidtestappa;

import android.graphics.Color;

public class Link {
    private long id;
    private int status;
    private String url;
    private String date;

    public long getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDate() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(String date) {
        this.date = date;
    }
}