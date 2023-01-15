package com.glasspanepopup.insert;

public class DataStorageInsProduct {

    public int getId_Stack() {
        return id_Stack;
    }

    public void setId_Stack(int id_Stack) {
        this.id_Stack = id_Stack;
    }

    public String getNama_Barang() {
        return nama_Barang;
    }

    public void setNama_Barang(String nama_Barang) {
        this.nama_Barang = nama_Barang;
    }

    public String getJenis_Barang() {
        return jenis_Barang;
    }

    public void setJenis_Barang(String jenis_Barang) {
        this.jenis_Barang = jenis_Barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public DataStorageInsProduct(int id_Stack, String nama_Barang, String jenis_Barang, int jumlah, String Description) {
        this.id_Stack = id_Stack;
        this.nama_Barang = nama_Barang;
        this.jenis_Barang = jenis_Barang;
        this.jumlah = jumlah;
        this.Description = Description;
    }

    public DataStorageInsProduct() {
    }
                  
    private int id_Stack;
    private String nama_Barang;
    private String jenis_Barang;
    private int jumlah;
    private String Description;
}
