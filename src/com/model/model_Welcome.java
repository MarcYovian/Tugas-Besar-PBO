
package com.model;

public class model_Welcome {

    public String getWelcome() {
        return welcome;
    }

   public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExc() {
        return exc;
    }

    public void setExc(String exc) {
        this.exc = exc;
    } 
    
    public model_Welcome(String welcome, String name, String exc) {
        this.welcome = welcome;
        this.name = name;
        this.exc = exc;
    }
    
    public model_Welcome(){
        
    }

    private String welcome;
    private String name;
    private String exc;
    
    
}
