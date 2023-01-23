package com.dataStorage;

public class editRak {

    public int getIdRak() {
        return idRak;
    }

    public void setIdRak(int idRak) {
        this.idRak = idRak;
    }

    public String getNamaGudang() {
        return namaGudang;
    }

    public void setNamaGudang(String namaGudang) {
        this.namaGudang = namaGudang;
    }

    public String getNamaRak() {
        return namaRak;
    }

    public void setNamaRak(String namaRak) {
        this.namaRak = namaRak;
    }

    public int getKapasitas() {
        return Kapasitas;
    }

    public void setKapasitas(int Kapasitas) {
        this.Kapasitas = Kapasitas;
    }

    public int getIsFull() {
        return isFull;
    }

    public void setIsFull(int isFull) {
        this.isFull = isFull;
    }

    private static editRak instance = null;

    public editRak() {
    }

    public static editRak getInstance() {
        if (instance == null) {
            instance = new editRak();
        }
        return instance;
    }
    
    private int idRak;
    private String namaGudang;
    private String namaRak;
    private int Kapasitas;
    private int isFull;
}
