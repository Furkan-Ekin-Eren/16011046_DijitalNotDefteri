package com.example.mobilproje;

import java.io.Serializable;
import java.util.Date;

public class Not implements Serializable {
    int id;
    int pri=0;
    String title;
    String content;
    String date;

    public Not(String title, String content,String date,int pri) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.pri=pri;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
