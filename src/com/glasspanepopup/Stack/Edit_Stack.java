package com.glasspanepopup.Stack;

import com.connection.DatabaseConnection;
import com.dataStorage.editRak;
import com.frame.Form_Stack;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.main.Main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.String.valueOf;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class Edit_Stack extends javax.swing.JPanel {

    DatabaseConnection db = new DatabaseConnection();
    ResultSet rs = null;
    private editRak data;
    
    
    public Edit_Stack() {
        initComponents();
        cbGudang();
        data = editRak.getInstance();
        cbNamGudang.setEnabled(false);
        txtNamaRak.setEnabled(false);

        int idRak = data.getIdRak();
        String namaGudang = data.getNamaGudang();
        String namaRak = data.getNamaRak();
        int kapasitas = data.getKapasitas();
        int isFull = data.getIsFull();
        
        cbNamGudang.setSelectedItem(namaGudang);
        txtNamaRak.setText(namaRak);
        txtKapasitas.setText(valueOf(kapasitas));
        
        txtKapasitas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaGudang = (String) cbNamGudang.getSelectedItem();
                    String namaRak = txtNamaRak.getText();
                    int kapasitas = Integer.parseInt(txtKapasitas.getText());
                    
                    if(namaGudang.equals("") || namaRak.equals("") || kapasitas <= 0){
                        throw new Exception("Isikan semua field yang tersedia atau pastikan data yang anda masukkan benar");
                    }
                    
                    rs = db.getData("SELECT id_Gudang, nama_Gudang FROM gudang WHERE nama_Gudang = '" + namaGudang +"'");
                    int id_Gudang= 0;
                    if(rs.next()){
                        id_Gudang = rs.getInt("id_Gudang");
                    }
                    rs = db.getData("SELECT * FROM rak_gudang WHERE id_Gudang = '" + id_Gudang + "' AND nama_Rak = '" + namaRak + "' AND id_Rak != '" + idRak + "'");
                    if(rs.next()){
                        throw new Exception("Nama Stack pada gudang yang anda pilih sudah tersedia");
                    }
                    else{
                        Message_Confirmation msc = new Message_Confirmation();
                        msc.setData(new Model_Message("Konfirmasi", "Apakah anda yakin mengubah data rak ?"));
                        msc.eventSUBMIT(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                GlassPanePopup.closePopupLast();
                                rs = db.getData("SELECT id_Gudang, nama_Gudang FROM gudang WHERE nama_Gudang = '" + namaGudang +"'");
                                int id_Gudang= 0;
                                try {
                                    if(rs.next()){
                                        id_Gudang = rs.getInt("id_Gudang");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(Edit_Stack.class.getName()).log(Level.SEVERE, null, ex);
                                }

//                                System.out.println(idRak + " " + id_Gudang + " " + namaRak + " " + kapasitas + " " + isFull);

                                String update = "UPDATE rak_gudang SET id_Rak = ?, id_Gudang = ?, nama_Rak = ?,  Kapasitas = ?, isFull = ? WHERE id_Rak = ?";
                                db.query("Update Berhasil", "Data Rak Berhasil DIUpdate", update, idRak, id_Gudang, namaRak, kapasitas, isFull, idRak);

                                Form_Stack form = new Form_Stack();
                                Main main = (Main) SwingUtilities.getWindowAncestor(Edit_Stack.this);
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
        jLabel5.setText("EDIT STACK");
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

        cbNamGudang.setLabeText("Nama Gudang");

        txtKapasitas.setHint("Kapasistas");

        btnSubmit.setText("Submit");

        txtNamaRak.setHint("Nama Rak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtKapasitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbNamGudang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaRak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(50, 50, 50)
                .addComponent(txtNamaRak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnSubmit;
    private com.swing.Combobox cbNamGudang;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.swing.MyTextField txtKapasitas;
    private com.swing.MyTextField txtNamaRak;
    // End of variables declaration//GEN-END:variables
}
