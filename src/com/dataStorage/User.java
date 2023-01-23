package com.dataStorage;

public class User {
    
    private static User instance = null;
    
    private User() {
    }
    
    public static User getInstance() {
        if(instance == null){
            instance = new User();
        }
        return instance;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    private String username;
    private String nameUser;
    private String email;
    private Boolean isAdmin;
}
