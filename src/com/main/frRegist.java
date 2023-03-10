package com.main;

import com.connection.DatabaseConnection;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.glasspanepopup.popup.Message_Confirmation;
import com.sun.jdi.connect.spi.Connection;
import com.swing.MyTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import swinger.glasspanepopup.GlassPanePopup;
import java.sql.ResultSet;
import javax.swing.Action;



public class frRegist extends javax.swing.JFrame {
    public static frRegist frame;
    public frRegist() {
        initComponents();
        GlassPanePopup.install(this);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegist = new com.swing.MyButton();
        jLabel1 = new javax.swing.JLabel();
        login1 = new com.component.Login();
        txtEmail = new com.swing.MyTextField();
        txtUsername = new com.swing.MyTextField();
        txtName = new com.swing.MyTextField();
        txtPassword = new com.swing.MyPasswordField();
        txtPasswordRep = new com.swing.MyPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRegist.setText("Login");
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 102));
        jLabel1.setText("Daftar");

        txtEmail.setHint("Email");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtUsername.setHint("Username");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtName.setHint("Name");

        txtPassword.setHint("Password");

        txtPasswordRep.setHint("Reply Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasswordRep, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtPasswordRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegist.setBackground(new Color(255,153,102));
        btnRegist.setForeground(new Color(250, 250, 250));
        btnRegist.setText("Daftar");
        btnRegist.setFont(new java.awt.Font("Poppins", 0, 13));
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/mail.png")));
        txtUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/user-Login.png")));
        txtName.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/user-Login.png")));
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/pass.png")));
        txtPasswordRep.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/pass.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        try {
            String nama = txtName.getText();
            String email = txtEmail.getText();
            String username = txtUsername.getText();
            String pass = txtPassword.getText();
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            DatabaseConnection db = new DatabaseConnection();
            if (nama.equals("") || email.equals("") || username.equals("") || pass.equals("") || txtPasswordRep.getText().equals("")) {
                throw new Exception("Isikan semua field yang tersesdia atau pastikan data yang anda masukkan benar");
            }
            if(!email.endsWith("@gmail.com")){
                throw new Exception("Format email yang dimasukkan salah, pastikan menggunakan domain @gmail.com");
            }
            if (!txtPasswordRep.getText().equals(pass)) {
                throw new Exception("Password Tidak Sesuai");
            }
            String cek = "SELECT username FROM user WHERE username = '" + username + "'";
            rs = db.getData(cek);
            if (rs.next()){
                Message ms = new Message();
                ms.setData(new Model_Message("Gagal Register", "Username User Telah Terpakai, silahkan menggunakan username yang lain"));
                ms.eventOK(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(ms);
            }else{
                Message_Confirmation msc = new Message_Confirmation();
                msc.setData(new Model_Message("Konfirmasi", "Apakah anda yakin ?"));
                msc.eventSUBMIT(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GlassPanePopup.closePopupLast();
                        String insertQuery = "INSERT INTO user(username, nama_User, email, password, isUsed, isAdmin) VALUES (?,?,?,?,?,?);";
                        db.query("Berhasil Register", "Selamat, Akun telah dibuat \n Silahkan menunggu untuk di confirmasi oleh Owner!!!", insertQuery, username,nama,email,pass,0,1);
                    }
                });
                GlassPanePopup.showPopup(msc);
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
    }//GEN-LAST:event_btnRegistActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myTextField1ActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed
    /**
    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new frRegist();
                frame.setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnRegist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.component.Login login1;
    private com.swing.MyTextField txtEmail;
    private com.swing.MyTextField txtName;
    private com.swing.MyPasswordField txtPassword;
    private com.swing.MyPasswordField txtPasswordRep;
    private com.swing.MyTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
