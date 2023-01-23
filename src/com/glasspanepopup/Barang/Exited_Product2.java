package com.glasspanepopup.Barang;

import com.connection.DatabaseConnection;
import com.dataStorage.User;
import com.dataStorage.editProduct;
import com.frame.Form_ProductList;
import com.glasspanepopup.Stack.insertStack;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.main.Main;
import com.model.StatusType;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class Exited_Product2 extends javax.swing.JPanel {

    private editProduct data;
    private User dataUser;
    ResultSet rs; 

    public Exited_Product2() {
        initComponents();
        
//        tpDeskripsi.setBackground(new Color(255,232,243, 0));
//        tpDeskripsi.setSelectionColor(new Color(255, 153, 102));
        
        txtJumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        data = editProduct.getInstance();
        dataUser = User.getInstance();
        
        String username = dataUser.getUsername();
        
        int idBarang = data.getIdBarang();
        int idRak = data.getIdRak();
        int idPelanggan = data.getIdPelanggan();
        String date = data.getDate();
        StatusType status = data.getStatus();
        
        String namaBarang = data.getNamaBarang();
        String Kategori = data.getKategori();
        int jumlah = data.getJumlah();
        String deskripsi = data.getDeskripsi();
        
        txtName.setText(namaBarang);
        txtKategori.setText(Kategori);
        tpDeskripsi.setText(deskripsi);
        
        txtName.setEnabled(false);
        txtKategori.setEnabled(false);
        tpDeskripsi.setEnabled(false);
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaProduk = txtName.getText();
                    String Kategori = txtKategori.getText();
                    int jumlah = Integer.parseInt(txtJumlah.getText());
                    String deskripsi = tpDeskripsi.getText();
                    if(namaProduk.equals("") || Kategori.equals("") || jumlah < 0 || deskripsi.equals("")){
                        throw new Exception("Isi semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }
                    else{
                        data.setNamaBarang(namaProduk);
                        data.setKategori(Kategori);
                        data.setJumlah(jumlah);
                        data.setDeskripsi(deskripsi);
                        
                        // Switch panel 1
                        Edit_Product edit = new Edit_Product();
                        Main main = (Main) SwingUtilities.getWindowAncestor(Exited_Product2.this);
                        main.setForm(edit);
                    }
                } catch (Exception ex) {
                    Message ms = new Message();
                    ms.setData(new Model_Message("Error", ex.getMessage()));
                    ms.eventOK(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(ms);
                }
            }
        });
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaProduk = txtName.getText();
                    String kategori = txtKategori.getText();
                    int jumlahExit = Integer.parseInt(txtJumlah.getText());
                    String deskripsi = tpDeskripsi.getText();
                        
                    DatabaseConnection db = new DatabaseConnection();
                    rs = db.getData("SELECT id_Barang, jumlah FROM barang WHERE id_Barang = '" + idBarang + "' AND jumlah < '" + jumlahExit + "'");
                    
                    if(namaProduk.equals("") || Kategori.equals("") || jumlah < 0 || deskripsi.equals("")){
                        throw new Exception("Isi semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }
                    if(rs.next()){
                        Message ms = new Message();
                        ms.setData(new Model_Message("Error" , "Jumlah yang anda inputkan melebihi jumlah yang ada pada rak \n SIlahkan ubah jumlah yang ingin dikirim"));
                        ms.eventOK(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                            }
                        });
                        GlassPanePopup.showPopup(ms);
                    }else{
                        Message_Confirmation msc = new Message_Confirmation();
                        msc.setData(new Model_Message("Konfirmasi", "Apakah anda yakin data yang anda masukkan sesuai ? "));
                        msc.eventSUBMIT(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                rs = db.getData("SELECT * FROM barang WHERE id_Barang = '" + idBarang + "'");
                                int jumlahBarang = 0;
                                try {
                                    if(rs.next()){
                                        jumlahBarang = rs.getInt("jumlah") - jumlahExit;
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(Exited_Product2.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                if(jumlahBarang > 0){
                                    rs = db.getData("SELECT * FROM barang WHERE nama_Barang = '" + namaBarang + "' AND isDeleted = 1");
                                    int idTemp = 0;
                                    int jumlahTemp = 0;
                                    try {
                                        if (rs.next()) {
                                            idTemp = rs.getInt("id_Barang");
                                            jumlahTemp = rs.getInt("jumlah") + jumlahExit;
                                            String updateProduct1 = "UPDATE barang SET jumlah = ? WHERE id_Barang = ? ;";
                                            db.query("Berhasil", "Barang berhasil di update", updateProduct1, jumlahTemp, idTemp);
                                    
                                            String updateProduct0 = "UPDATE barang SET jumlah = ? WHERE id_Barang = ? ;";
                                            db.query("Berhasil", "Barang berhasil di update", updateProduct0, jumlahBarang, idBarang);
                                        
                                            String Status = status.name();
                                            String insertNote = "INSERT INTO pencatatan(id_Rak, username, id_Barang, id_Pelanggan, tanggal, status) VALUES (?,?,?,?,?,?)";
                                            db.query("Insert Berhasil", "Berhasil Menambahkan Pencatatan Baru", insertNote, idRak, username, idTemp, idPelanggan,date, Status);
                                        
                                        }else{
                                            String insertProductDeleted = "INSERT INTO barang(id_Rak, nama_Barang, kategori_Barang, jumlah, deskripsi, isDeleted) VALUES (?,?,?,?,?,?)";
                                            db.query("Berhasil", "Barang Berhasil Keluar Gudang", insertProductDeleted, idRak, namaProduk, Kategori, jumlahExit, deskripsi, 1);
                                            
                                            String updateProduct0 = "UPDATE barang SET jumlah = ? WHERE id_Barang = ? ;";
                                            db.query("Berhasil", "Barang berhasil di update", updateProduct0, jumlahBarang, idBarang);
                                       
                                            DatabaseConnection dbc = new DatabaseConnection();
                                            int id_Barang = 0;
                                            rs = dbc.getData("SELECT * FROM barang WHERE nama_Barang = '" + namaProduk + "' AND isDeleted = 1");
                                            try {
                                                if(rs.next()){
                                                    id_Barang = rs.getInt("id_Barang");
                                                }
                                            } catch (SQLException ex) {
                                                Logger.getLogger(insertStack.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            String Status = status.name();
                                            String insertNote = "INSERT INTO pencatatan(id_Rak, username, id_Barang, id_Pelanggan, tanggal, status) VALUES (?,?,?,?,?,?)";
                                            db.query("Insert Berhasil", "Berhasil Menambahkan Pencatatan Baru", insertNote, idRak, username, id_Barang, idPelanggan,date, Status);
                                            
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Exited_Product2.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                                                    
                                }else{
                                    String update = "UPDATE barang SET isDeleted = 1 WHERE id_Barang = ?";
                                    db.query("Berhasil", "Barang Berhasil Keluar Gudang", update, idBarang);
                                    
                                    String Status = status.name();
                                    String insertNote = "INSERT INTO pencatatan(id_Rak, username, id_Barang, id_Pelanggan, tanggal, status) VALUES (?,?,?,?,?,?)";
                                    db.query("Insert Berhasil", "Berhasil Menambahkan Pencatatan Baru", insertNote, idRak, username, idBarang, idPelanggan,date, Status);
                                }
                                Form_ProductList form = new Form_ProductList();
                                Main main = (Main) SwingUtilities.getWindowAncestor(Exited_Product2.this);
                                main.setForm(form);
                            }
                        });
                        GlassPanePopup.showPopup(msc);
                    }
                } catch (Exception ex) {
                    Message ms = new Message();
                    ms.setData(new Model_Message("Error", ex.getMessage()));
                    ms.eventOK(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(ms);
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new com.swing.MyButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new com.swing.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpDeskripsi = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        txtKategori = new com.swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        txtJumlah = new com.swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSubmit = new com.swing.MyButton();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(252, 251, 246));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("PRODUCT");
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Nama Produk");

        txtName.setHint("Nama");

        tpDeskripsi.setBackground(new java.awt.Color(255, 232, 243));
        tpDeskripsi.setCaretColor(new java.awt.Color(255, 232, 243));
        tpDeskripsi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tpDeskripsi.setName(""); // NOI18N
        jScrollPane1.setViewportView(tpDeskripsi);
        tpDeskripsi.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 243, 206));
        jLabel6.setText("STACK");
        jLabel6.setVerifyInputWhenFocusTarget(false);

        txtKategori.setHint("Kategori");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Kategori Produk");

        txtJumlah.setHint("Jumlah");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Jumlah Produk");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Deskripsi");

        jPanel1.setBackground(new java.awt.Color(250, 243, 206));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        btnBack.setBackground(new Color(250, 250, 250));
        btnBack.setForeground(new Color(255,153,102));
        btnBack.setText("Back");
        btnBack.setFont(new java.awt.Font("Poppins", 0, 13));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setText("Submit");
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnBack;
    private com.swing.MyButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane tpDeskripsi;
    private com.swing.MyTextField txtJumlah;
    private com.swing.MyTextField txtKategori;
    private com.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
