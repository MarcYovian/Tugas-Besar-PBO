package com.glasspane.popup.warehouse;

import com.connection.DatabaseConnection;
import com.frame.Form_Warehouse;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.main.Main;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class Insert_Warehouse extends javax.swing.JPanel {

    public Insert_Warehouse() {
        initComponents();
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaGudang = txtNamGudang.getText();
                    String alamat = txtAlamat.getText();
                    Connection con = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                            
                    DatabaseConnection db = new DatabaseConnection();
                    String cekQuery = "SELECT nama_Gudang FROM gudang WHERE nama_Gudang = '" + namaGudang + "'";
                    rs = db.getData(cekQuery);
                    if(namaGudang.equals("") || alamat.equals("")){
                        throw new Exception();
                    }else if(rs.next()){
                        Message ms = new Message();
                        ms.setData(new Model_Message("Error","Nama Gudang Sudah Tersedia"));
                        ms.eventOK(new ActionListener(){
                        @Override
                             public void actionPerformed(ActionEvent e) {
                                 GlassPanePopup.closePopupLast();
                             }
                        });
                        GlassPanePopup.showPopup(ms);
                    }else{
                        Message_Confirmation msc = new Message_Confirmation();
                        msc.setData(new Model_Message("Konfirmasi", "Apakah anda yakin ingin menambahkan gudang Baru ?"));
                        msc.eventSUBMIT(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                        
                                    String insertQuery = "INSERT INTO gudang (nama_Gudang, alamat) VALUES (?,?)";
                                    db.queryWarehouse(insertQuery,namaGudang, alamat);
                                    System.out.println(namaGudang + "\n" + alamat);
                                    
                                    // set panel Form_Warehouse 
                                    Form_Warehouse wh = new Form_Warehouse();
                                    Main main = (Main) SwingUtilities.getWindowAncestor(Insert_Warehouse.this);
                                    main.setForm(wh);
                            }
                        });
                        GlassPanePopup.showPopup(msc);
                    }
                   
                } catch (Exception ex) {
                    Message ms = new Message();
                    ms.setData(new Model_Message("Error", "Mohon untuk mengisi semau field yang ada"));
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

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNamGudang = new com.swing.MyTextField();
        txtAlamat = new com.swing.MyTextField();
        btnSubmit = new com.swing.MyButton();

        setBackground(new java.awt.Color(252, 251, 246));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 102));
        jLabel5.setText("WAREHOUSE");
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

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

        txtNamGudang.setHint("Nama Gudang");

        txtAlamat.setHint("Alamat");

        btnSubmit.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txtNamGudang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(txtNamGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnSubmit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.swing.MyTextField txtAlamat;
    private com.swing.MyTextField txtNamGudang;
    // End of variables declaration//GEN-END:variables
}
