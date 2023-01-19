package com.glasspanepopup.Barang;

public class DataStorageInsProduct {

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public DataStorageInsProduct(int id_Stack, String date, int idPelanggan, String nama_Barang, String jenis_Barang, int jumlah, String Description, String Status) {
        this.id_Stack = id_Stack;
        this.date = date;
        this.idPelanggan = idPelanggan;
        this.nama_Barang = nama_Barang;
        this.jenis_Barang = jenis_Barang;
        this.jumlah = jumlah;
        this.Description = Description;
        this.Status = Status;
    }

    public DataStorageInsProduct() {
    }
    
    
                 
    private int id_Stack;
    private String date;
    private int idPelanggan;
    private String nama_Barang;
    private String jenis_Barang;
    private int jumlah;
    private String Description;
    private String Status;
}
