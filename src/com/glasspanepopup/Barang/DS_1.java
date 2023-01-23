package com.glasspanepopup.Barang;

import com.model.StatusType;

public class DS_1 {

    private static DS_1 instance = null;
    
    private DS_1() {
    }
    
    public static DS_1 getInstance() {
        if(instance == null){
            instance = new DS_1();
        }
        return instance;
    }
    
    public int getId_Stack() {
        return id_Stack;
    }

    public void setId_Stack(int id_Stack) {
        this.id_Stack = id_Stack;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public StatusType getStatus() {
        return Status;
    }

    public void setStatus(StatusType Status) {
        this.Status = Status;
    }
                     
    private int id_Stack;
    private String date;
    private int idPelanggan;
    private StatusType Status;
}
