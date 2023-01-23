package com.glasspanepopup.Barang;

import com.connection.DatabaseConnection;
import com.dataStorage.editProduct;
import static com.dataStorage.editProduct.getInstance;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.main.Main;
import com.model.StatusType;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class Edit_Product extends javax.swing.JPanel {

    private editProduct data;
    
    public Edit_Product() {
        initComponents();
        
        cbIdPelanggan.setEnabled(false);
        txtDate.setEnabled(false);
        btnDate.setEnabled(false);
        displayIdRak();
        displayStatus();
        displayIdPelanggan();
        
        data = editProduct.getInstance();
        int idBarang = data.getIdBarang();
        int idRak = data.getIdRak();
        int idPelanggan = data.getIdPelanggan();
        String date = data.getDate();
        StatusType status = data.getStatus();
        
        String namaBarang = data.getNamaBarang();
        String Kategori = data.getKategori();
        int jumlah = data.getJumlah();
        String deskripsi = data.getDeskripsi();
        
        cbIdStack.setSelectedItem(idRak);
        cbIdPelanggan.setSelectedItem(idPelanggan);
        cbStatus.setSelectedItem(status);
        txtDate.setText(date);
        
        System.out.println(idRak + " " + idPelanggan + " " + status + " " + date);
        
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idRak = (int) cbIdStack.getSelectedItem();
                    int idPelanggan = (int) cbIdPelanggan.getSelectedItem();
                    String date = txtDate.getText();
                    StatusType status = (StatusType) cbStatus.getSelectedItem();

                    if (idRak <= 0 || idPelanggan <= 0 || date.equals("") || status.equals("")) {
                        throw new Exception("Isi semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }else{
                        data.setIdRak(idRak);
                        data.setIdPelanggan(idPelanggan);
                        data.setDate(date);
                        data.setStatus(status);
                        
                        //Switch panel 2
                        Edit_Product2 edit = new Edit_Product2();
                        Main main = (Main) SwingUtilities.getWindowAncestor(Edit_Product.this);
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
    }
    
    private void displayIdRak(){
        DatabaseConnection db = new DatabaseConnection();
        ResultSet rs;
        
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbIdStack.getModel();
            model.removeAllElements();
            rs = db.getData("SELECT * FROM rak_gudang");
            while (rs.next()) {                
                int id = rs.getInt("id_Rak");
                cbIdStack.addItem(id);
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
    
    private void displayIdPelanggan(){
        DatabaseConnection db = new DatabaseConnection();
        ResultSet rs;
        
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbIdPelanggan.getModel();
            model.removeAllElements();
            rs = db.getData("SELECT * FROM pelanggan");
            while (rs.next()) {                
                int id = rs.getInt("id_Pelanggan");
                cbIdPelanggan.addItem(id);
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
    
    public void displayStatus(){
        for(StatusType status : StatusType.values()){
            cbStatus.addItem(status);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        btnDate = new com.swing.MyButton();
        cbIdStack = new com.swing.Combobox();
        cbIdPelanggan = new com.swing.Combobox();
        cbStatus = new com.swing.Combobox();
        btnNext = new com.swing.MyButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDate = new com.swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();

        date.setForeground(new java.awt.Color(255, 153, 102));
        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(txtDate);

        setBackground(new java.awt.Color(252, 251, 246));

        btnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/calendar.png"))); // NOI18N
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        cbIdStack.setLabeText("id Stack");

        cbIdPelanggan.setLabeText("Id Pelanggan");

        cbStatus.setLabeText("Status");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 102));
        jLabel6.setText("STACK");
        jLabel6.setVerifyInputWhenFocusTarget(false);

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

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 243, 206));
        jLabel5.setText("PRODUCT");
        jLabel5.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(250, 243, 206));

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

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Tanggal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(98, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbIdStack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbIdPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIdStack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnDate.setBackground(new Color(255,153,102));
        btnNext.setBackground(new Color(255,153,102));
        btnNext.setForeground(new Color(250, 250, 250));
        btnNext.setText("Next");
        btnNext.setFont(new java.awt.Font("Poppins", 0, 13));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        date.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    }//GEN-LAST:event_btnNextActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnDate;
    private com.swing.MyButton btnNext;
    private com.swing.Combobox cbIdPelanggan;
    private com.swing.Combobox cbIdStack;
    private com.swing.Combobox cbStatus;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.swing.MyTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
