package com.model;

public enum StatusType {
    INCOMING,               // Barang Masuk ke Gudang
    OUTGOING,             // Barang Keluar Gudang
    TRANSFERRED,     // Barang dipindahkan antar stack (UPDATE)
    RETURNED,                 // Pengembalian Produk
}
