
package com.main;

import com.connection.DatabaseConnection;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.swing.MyTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane;
import swinger.glasspanepopup.GlassPanePopup;

public class frLogin extends javax.swing.JFrame {
    frLogin frLogin = this;
    public frLogin() {
        initComponents();
        GlassPanePopup.install(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new com.swing.MyButton();
        LPass = new javax.swing.JLabel();
        LUser = new javax.swing.JLabel();
        txtUsername = new com.swing.MyTextField();
        txtPassword = new com.swing.MyPasswordField();
        regist1 = new com.component.Regist();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(1075, 557));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 102));
        jLabel1.setText("Login");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        LPass.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LPass.setForeground(new java.awt.Color(255, 153, 102));

        LUser.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LUser.setForeground(new java.awt.Color(255, 153, 102));

        txtUsername.setHint("Username");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setHint("Password");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LUser, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(regist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LUser, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(LPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(regist1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnLogin.setBackground(new Color(255,153,102));
        btnLogin.setForeground(new Color(250, 250, 250));
        btnLogin.setText("Masuk");
        btnLogin.setFont(new java.awt.Font("Poppins", 0, 13));
        txtUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/user-Login.png")));
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/icon/pass.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUsername.getText();
        String pass = txtPassword.getText();
        String trueUser = "admin";
        String truePass = "admin";
        
        try {
            DatabaseConnection db = new DatabaseConnection();
            String query = "SELECT * FROM user WHERE username = '" + user + "' AND password = '" + pass + "'";
            ResultSet rs = db.getData(query);
            if(rs.next() && rs.getInt("isUsed")==1){
                Message ms = new Message();
                ms.setData(new Model_Message("Berhasil Login", "Username dan Password Anda Benar"));
                ms.eventOK(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Main().setVisible(true);
                        frLogin.dispose();
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(ms);
                
            }else if(rs.next() && rs.getInt("isUsed")==0){ // error, cari solusi dulu ges
                Message ms = new Message();
                ms.setData(new Model_Message("Akun belum bisa digunakan", "Mohon maaf, akun belum bisa digunakan\n Silahkan tunggu sampai akun anda telah di Setujui oleh Owner!"));
                ms.eventOK(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(ms);
            }else{// nder, edit nde bawah iki yo hehe
                Message ms = new Message();
                ms.setData(new Model_Message("Username / Password Not Found", "Username dan Password tidak ditemukan\n mohon untuk melakukan pendaftaran terlebih dahulu!"));
                ms.eventOK(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(ms);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        /*
        if(user.equals(trueUser)&&pass.equals(truePass)){
            new Main().setVisible(true);
            this.dispose();
        }else{
            LUser.setText("");
            LPass.setText("");
            if (user.equals("")&&pass.equals("")){
                LUser.setText("Kosong!");
                LPass.setText("Kosong!");
            }else{
                if(user.equals("")||pass.equals("")){
                    if(txtUsername.getText().equals("")){
                        LUser.setText("Kosong!");
                    }
                    if(pass.equals("")){
                        LPass.setText("Kosong!");
                    }
                }else{
                    if(user.equals(trueUser)){
                            LPass.setText("Password Salah!");
                    }else{
                        LUser.setText("Username Salah!");
                        LPass.setText("Password Salah!");
                    }
                }
            }
            txtUsername.setText("");
            txtPassword.setText("");
        }*/
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(frLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {  
                new frLogin().setVisible(true);
            }
        });
    }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LPass;
    private javax.swing.JLabel LUser;
    private com.swing.MyButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.component.Regist regist1;
    private com.swing.MyPasswordField txtPassword;
    private com.swing.MyTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
