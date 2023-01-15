package com.glasspanepopup.model;

public class Model_Message {

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Model_Message(String Title, String message) {
        this.Title = Title;
        this.message = message;
    }

    public Model_Message() {
    }      
    
    private String Title;
    private String message;
}
