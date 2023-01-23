package com.glasspanepopup.Barang;

import com.connection.DatabaseConnection;
import com.dataStorage.User;
import com.frame.Form_ProductList;
import com.glasspanepopup.Stack.insertStack;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.main.Main;
import com.model.StatusType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class insertProduct2 extends javax.swing.JPanel {
    
    private DS_2 data;
    private DS_1 data2;
    private User dataUser;
    ResultSet rs; 
    
    public insertProduct2(){ 
        initComponents();
//        setOpaque(false);
//
//        tpDeskripsi.setBackground(new Color(255,232,243, 0));
//        tpDeskripsi.setSelectionColor(new Color(255, 153, 102));
//        tpDeskripsi.setOpaque(false);
        txtJumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        data = DS_2.getInstance();
        data2 = DS_1.getInstance();
        dataUser = User.getInstance();
        String namaProduk = data.getNama_Barang();
        String Kategori = data.getJenis_Barang();
        int jumlah = data.getJumlah();
        String deskripsi = data.getDescription();
        
        int id_Rak = data2.getId_Stack();
        String date = data2.getDate();
        int id_Pelanggan = data2.getIdPelanggan();
        StatusType status = data2.getStatus();
        
        String username = dataUser.getUsername();
        
        // Set text fields value based on data
        if(namaProduk!=null&&!namaProduk.equals("")){
            txtName.setText(namaProduk);
        }
        if(Kategori!=null&&!Kategori.equals("")){
            txtKategori.setText(Kategori);
        }
        if (jumlah>0) {
            txtJumlah.setText(String.valueOf(jumlah));
        }
        if(deskripsi!=null && !deskripsi.equals("")){
            tpDeskripsi.setText(deskripsi);
        }
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String namaProduk = txtName.getText();
                    String Kategori = txtKategori.getText();
                    int jumlah = Integer.parseInt(txtJumlah.getText());
                    String deskripsi = tpDeskripsi.getText();
                    if(namaProduk.equals("") || Kategori.equals("") || jumlah < 0 || deskripsi.equals("")){
                        throw new Exception("Isi semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }
                    data.setNama_Barang(namaProduk);
                    data.setJenis_Barang(Kategori);
                    data.setJumlah(jumlah);
                    data.setDescription(deskripsi);

                    // switch panel 1
                    insertProduct ins = new insertProduct();
                    Main main = (Main) SwingUtilities.getWindowAncestor(insertProduct2.this);
                    main.setForm(ins);
                }catch(Exception ex){
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
                    int jumlah = Integer.parseInt(txtJumlah.getText());
                    String deskripsi = tpDeskripsi.getText();
                    
                    DatabaseConnection db = new DatabaseConnection();
                    
                    
                    int total = count(id_Rak) + jumlah;
                    
                    rs = db.getData("SELECT id_Rak, Kapasitas FROM rak_gudang WHERE id_Rak = '" + id_Rak + "' AND Kapasitas < '" + total + "'");
                    if (namaProduk.equals("") || kategori.equals("") || jumlah < 0 || deskripsi.equals("")) {
                        throw new Exception();
                    }
                    if(rs.next()){
                        Message ms = new Message();
                        ms.setData(new Model_Message("Error" , "Kapasitas pada rak yang anda pilih tidak cukup, silahkan untuk mengganti rak yang lain"));
                        ms.eventOK(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                            }
                        });
                        GlassPanePopup.showPopup(ms);
                    }else{
                        Message_Confirmation msc = new Message_Confirmation();
                        msc.setData(new Model_Message("Konfirmasi", "Apakah Data yang anda masukkan sudah benar ? "));
                        msc.eventSUBMIT(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                String insertProduct = "INSERT INTO barang(id_Rak, nama_Barang, kategori_Barang, jumlah, deskripsi, isDeleted) VALUES (?,?,?,?,?,?)";
                                db.query("Insert Berhasil", "Berhasil Menambahkan Produk Baru", insertProduct, id_Rak, namaProduk, Kategori, jumlah, deskripsi, 0);
                                
                                DatabaseConnection dbc = new DatabaseConnection();
                                int id_Barang = 0;
                                rs = dbc.getData("SELECT * FROM barang WHERE nama_Barang = '" + namaProduk + "'");
                                try {
                                    if(rs.next()){
                                        id_Barang = rs.getInt("id_Barang");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(insertStack.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                String Status = status.name(); 
                                System.out.println(id_Rak + " " + username + " " + id_Barang + " " + date + " " + Status);
                                String insertNote = "INSERT INTO pencatatan(id_Rak, username, id_Barang, id_Pelanggan, tanggal, status) VALUES (?,?,?,?,?,?)";
                                db.query("Insert Berhasil", "Berhasil Menambahkan Pencatatan Gudang Baru", insertNote, id_Rak, username, id_Barang, id_Pelanggan,date, Status);
                                
                                // Switch to panel Form_ProductList
                                Form_ProductList form = new Form_ProductList();
                                Main main = (Main) SwingUtilities.getWindowAncestor(insertProduct2.this);
                                main.setForm(form);                               
                            }
                        });
                        GlassPanePopup.showPopup(msc);
                    }                   
                } catch (Exception ex) {
                    Message ms = new Message();
                    ms.setData(new Model_Message("Error" , "Isi semua field yang tersedia atau pastikan data yang anda masukkan benar"));
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
    
    public int count(int id_Rak){
        int total = 0;
        DatabaseConnection db = new DatabaseConnection();
        rs = db.getData("SELECT * FROM barang WHERE id_Rak = '" + id_Rak + "' AND isDeleted = 0");
        try {
            while (rs.next()) {
                int jumlah = rs.getInt("jumlah");
                total = total + jumlah;
            }
        } catch (SQLException ex) {
            Logger.getLogger(insertProduct2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new com.swing.MyButton();
        btnBack = new com.swing.MyButton();
        txtName = new com.swing.MyTextField();
        txtKategori = new com.swing.MyTextField();
        txtJumlah = new com.swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpDeskripsi = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(252, 251, 246));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtName.setHint("Nama");

        txtKategori.setHint("Kategori");

        txtJumlah.setHint("Jumlah");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Nama Produk");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Kategori Produk");

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

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("PRODUCT");
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 243, 206));
        jLabel6.setText("STACK");
        jLabel6.setVerifyInputWhenFocusTarget(false);

        tpDeskripsi.setBackground(new java.awt.Color(255, 232, 243));
        tpDeskripsi.setCaretColor(new java.awt.Color(255, 232, 243));
        tpDeskripsi.setDisabledTextColor(new java.awt.Color(255, 232, 243));
        tpDeskripsi.setName(""); // NOI18N
        jScrollPane1.setViewportView(tpDeskripsi);
        tpDeskripsi.setBorder(null);

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

        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setText("Submit");
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
        btnBack.setBackground(new Color(250, 250, 250));
        btnBack.setForeground(new Color(255,153,102));
        btnBack.setText("Back");
        btnBack.setFont(new java.awt.Font("Poppins", 0, 13));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
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
