package com.glasspanepopup.Barang;

public class DS_2 {
    
    private static DS_2 instance = null;
    
    private DS_2() {
    }
    
    public static DS_2 getInstance() {
        if(instance == null){
            instance = new DS_2();
        }
        return instance;
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
    private String nama_Barang;
    private String jenis_Barang;
    private int jumlah;
    private String Description;
}
