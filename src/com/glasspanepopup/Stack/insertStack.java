package com.glasspanepopup.Stack;

import com.frame.Form_Stack;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.main.Main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.numberOfLeadingZeros;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import swinger.glasspanepopup.GlassPanePopup;

public class insertStack extends javax.swing.JPanel {

    public insertStack() {
        initComponents();
//        setOpaque(false);
        
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String namaGudang = (String) cbNamGudang.getSelectedItem();
                    int Kapasistas = Integer.parseInt(txtKapasitas.getText());
                    if(namaGudang.equals("") || Kapasistas <= 0){
                        throw new Exception();
                    }
                    System.out.println(namaGudang + " " + Kapasistas );
                    // to do : insert query to database here & check if namaGudang already exists

                    
                    //switch panel Stack
                    Form_Stack stack = new Form_Stack();
                    Main main = (Main) SwingUtilities.getWindowAncestor(insertStack.this);
                    main.setForm(stack);
                    
                } catch (Exception ex){
                    Message ms = new Message();
                    ms.setData(new Model_Message("Error", "Isikan semua field yang tersedia atau pastikan data yang anda masukkan benar"));
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
        cbNamGudang = new com.swing.Combobox();
        txtKapasitas = new com.swing.MyTextField();
        btnSubmit = new com.swing.MyButton();

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        cbNamGudang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Test 1", "halo semua" }));
        cbNamGudang.setSelectedIndex(-1);
        cbNamGudang.setLabeText("Nama Gudang");

        txtKapasitas.setHint("Kapasistas");

        btnSubmit.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNamGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(cbNamGudang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
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
    // End of variables declaration//GEN-END:variables
}
