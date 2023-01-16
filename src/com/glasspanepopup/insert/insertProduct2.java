package com.glasspanepopup.insert;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import swinger.glasspanepopup.GlassPanePopup;

public class insertProduct2 extends javax.swing.JPanel {
//    insertProduct2 panel = new insertProduct2();
    public insertProduct2(){ 
        initComponents();
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new com.swing.MyButton();
        btnBack = new com.swing.MyButton();
        txtTest = new com.swing.MyTextField();

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

        txtTest.setHint("Hallo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        btnSubmit.setBackground(new Color(255,153,102));
        btnSubmit.setForeground(new Color(250, 250, 250));
        btnSubmit.setText("Submit");
        btnSubmit.setFont(new java.awt.Font("Poppins", 0, 13));
        btnBack.setBackground(new Color(250, 250, 250));
        btnBack.setForeground(new Color(255,153,102));
        btnBack.setText("Back");
        btnBack.setFont(new java.awt.Font("Poppins", 0, 13));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                 String test = txtTest.getText();
                
                DataStorageInsProduct data = new DataStorageInsProduct();
                data.setJenis_Barang(test);
                
                insertProduct ins = new insertProduct();
                ins.eventNEXT(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         GlassPanePopup.closePopupLast();
                     }
                    
                });
                GlassPanePopup.showPopup(ins);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    public void eventSubmit(ActionListener event){
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GlassPanePopup.closePopupAll();
            }
        });
    }
    
    public void eventBACK(ActionListener event){
        btnBack.addActionListener(event);
    }
    
    public void eventSUBMIT(ActionListener event){
        btnSubmit.addActionListener(event);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnBack;
    private com.swing.MyButton btnSubmit;
    private com.swing.MyTextField txtTest;
    // End of variables declaration//GEN-END:variables
}
