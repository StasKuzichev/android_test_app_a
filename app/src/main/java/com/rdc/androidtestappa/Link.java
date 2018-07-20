package com.rdc.androidtestappa;

import java.util.Date;

public class Link implements Comparable{								//модель ссылки
    private int id, status;
    private String url;
    private Date date;

    Link(int id, String url, int status, Date date){			    //присваивание параметров
        this.id = id;
        this.status = status;
        this.url = url;
        this.date = date;
    }
    public int compareTo(Object obj) {								    //переопределение для сортировки по статусу ссылки
        int result = this.status - ((Link)obj).status;
        if(result!=0) {
            return result;
        }
        else {
            return 1;
        }
    }
    public String toString() {
        return "\n" + this.id + " " + this.url + " " + this.status + " " + this.date;
    }
    public int GetID() {												//Геттер id
        return this.id;
    }
    public int GetStatus() {											//Геттер статуса
        return this.status;
    }
    public String GetURL() {											//Геттер ссылки
        return this.url;
    }
    public Date GetDate() {										//Геттер даты/времени
        return this.date;
    }
}

