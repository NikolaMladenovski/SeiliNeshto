package com.example.dimov.seilineshto;


public class Item {

    private int _id;
    private String name;
    private String date;
    private String score;

    public Item() {
    }

    public Item(String name, String date, String score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

