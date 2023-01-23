package com.dataStorage;

public class editWarehouse {

    private static editWarehouse instance = null;
    
    private editWarehouse() {
    }
    
    public static editWarehouse getInstance() {
        if(instance == null){
            instance = new editWarehouse();
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
    private int id;
    private String nama;
    private String alamat;
}
