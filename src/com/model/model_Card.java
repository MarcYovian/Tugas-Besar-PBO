package com.model;

public class model_Card {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum (int num) {
        this.num = num;
    }

    public model_Card(String title, int num) {
        this.title = title;
        this.num = num;
    }
    
    public model_Card(){
    }
    
    private String title;
    private int num;
}
