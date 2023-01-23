package com.dataStorage;

public class editCust {

    private static editCust instance = null;

    public editCust() {
    }

    public static editCust getInstance() {
        if (instance == null) {
            instance = new editCust();
        }
        return instance;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public int getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(int isSupplier) {
        this.isSupplier = isSupplier;
    }
    private int id;
    private String nama;
    private String alamat;
    private String email;
    private String nomer;
    private int isSupplier;
}
