package com.dataStorage;

import com.model.StatusType;

public class editProduct extends abstractClass{
    
    private static editProduct instance = null;

    public editProduct() {
    }

    public static editProduct getInstance() {
        if (instance == null) {
            instance = new editProduct();
        }
        return instance;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdRak() {
        return idRak;
    }

    public void setIdRak(int idRak) {
        this.idRak = idRak;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    int hitungTotal() {
        int total = 0;
        return total;
    }
    
    
    
    private int idBarang;
    private int idRak;
    private int idPelanggan;
    private String date;
    private StatusType status;
    private String namaBarang;
    private String kategori;
    private int jumlah;
    private String deskripsi;
}
