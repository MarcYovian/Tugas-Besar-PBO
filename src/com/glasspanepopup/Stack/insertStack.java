package com.glasspanepopup.Stack;

import com.connection.DatabaseConnection;
import com.frame.Form_Stack;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.main.Main;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.numberOfLeadingZeros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class insertStack extends javax.swing.JPanel {
    ResultSet rs = null;
                    
    DatabaseConnection db = new DatabaseConnection();
    public insertStack() {
        initComponents();
//        setOpaque(false);

        txtKapasitas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        cbGudang();
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaGudang = (String) cbNamGudang.getSelectedItem();
                    String namaRak = txtNamaRak.getText();
                    int Kapasitas = Integer.parseInt(txtKapasitas.getText());
                    Connection con = null;
                    PreparedStatement pstmt = null;

                    String setId = "SELECT id_Gudang, nama_Gudang FROM gudang WHERE nama_Gudang = '" + namaGudang + "'";
                    rs = db.getData(setId);
                    int id = 0;
                    try {
                        while (rs.next()) {
                            id = rs.getInt("id_Gudang");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(insertStack.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String cekQuery = "SELECT id_Gudang, id_Rak FROM rak_gudang WHERE id_Gudang = '"+ id + "' AND nama_Rak = '" + namaRak + "'" ;
                    rs = db.getData(cekQuery);
                    if(namaGudang.equals("") || Kapasitas <= 0 || namaRak.equals("")){
                        throw new Exception("Isikan semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }else if(rs.next()){
                        Message ms = new Message();
                        ms.setData(new Model_Message("Error", "Nama stack pada gudang yang anda pilih sudah tersedia"));
                        ms.eventOK(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                            }
                        });
                        GlassPanePopup.showPopup(ms);
                    }else{
                        Message_Confirmation msc = new Message_Confirmation();
                        msc.setData(new Model_Message("Konfimasi", "Apakah anda yakin ingin menambah Rak Baru untuk gudang yang anda Pilih ?"));
                        msc.eventSUBMIT(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                String setId = "SELECT id_Gudang, nama_Gudang FROM gudang WHERE nama_Gudang = '" + namaGudang + "'";
                                rs = db.getData(setId);
                                int id = 0;
                                try {
                                    while (rs.next()) {
                                        id = rs.getInt("id_Gudang");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(insertStack.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                String insertQuery = "INSERT INTO rak_gudang (id_Gudang, nama_Rak, Kapasitas, isFull) VALUES (?,?,?,?) ";
                                db.query("Berhasil", "Berhasil Menambah Rak Baru", insertQuery, id, namaRak, Kapasitas, 0);
                                
                                //switch panel Stack
                                Form_Stack s = new Form_Stack();
                                Main main = (Main) SwingUtilities.getWindowAncestor(insertStack.this);
                                main.setForm(s);
                            }
                        });
                        GlassPanePopup.showPopup(msc);
                    }
                } catch (Exception ex){
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

    private void cbGudang(){
        DatabaseConnection db = new DatabaseConnection();
        ResultSet rs = null;
        
        try {
            String cek = "SELECT * FROM gudang" ;
            rs = db.getData(cek);
            while (rs.next()) {                
                String nama = rs.getString("nama_Gudang");
                cbNamGudang.addItem(nama);
            }
        } catch (Exception e) {
            Message ms = new Message();
            ms.setData(new Model_Message("Error", e.getMessage()));
            ms.eventOK(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(ms);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbNamGudang = new com.swing.Combobox();
        txtKapasitas = new com.swing.MyTextField();
        btnSubmit = new com.swing.MyButton();
        txtNamaRak = new com.swing.MyTextField();

        setBackground(new java.awt.Color(252, 251, 246));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("STACK");
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        cbNamGudang.setSelectedIndex(-1);
        cbNamGudang.setLabeText("Nama Gudang");

        txtKapasitas.setHint("Kapasistas");

        btnSubmit.setText("Submit");

        txtNamaRak.setHint("Nama Rak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKapasitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNamGudang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaRak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cbNamGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(txtNamaRak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
    }// </editor-fold>//GEN-END:initComponents

    public void eventSUBMIT(ActionListener event){
        btnSubmit.addActionListener(event);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnSubmit;
    private com.swing.Combobox cbNamGudang;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.swing.MyTextField txtKapasitas;
    private com.swing.MyTextField txtNamaRak;
    // End of variables declaration//GEN-END:variables
}
