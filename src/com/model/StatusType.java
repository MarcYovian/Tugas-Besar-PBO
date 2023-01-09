package com.model;

public enum StatusType {
    RECEIVING_AND_PUTAWAY,           // Penerimaan barang, dan penempatan barang
    DISPATCHING,            // Pencarian penempatan barang
    PICKING,                    // Pengumpulan produk
    PACKING,                    // Penggabungan barang atau pengemasan barang yg dipesan
    RETURNS,                 // Pengembalian Produk
    STOCK_TAKE,         // Pengecekan barang fisik dan system
    SHIPPING               // Proses Pengiriman Barang
}
