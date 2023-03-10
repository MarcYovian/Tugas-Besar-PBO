package com.main;

import com.dataStorage.User;
import com.frame.*;
import com.event.*;
import javax.swing.JComponent;
import swinger.glasspanepopup.GlassPanePopup;


public class Main extends javax.swing.JFrame {

    
    private Form_Dasboard dasboard;
    private Form_ProductList productList;
    private Form_Stack stackList;
    private Form_Warehouse warehouseList;
    private Form_User userList;
    private Form_Customer customer;
    private User data;
    
    Main Main = this;
    
    public Main() {
        initComponents();
        
        GlassPanePopup.install(this);
        data = User.getInstance();
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
//                System.out.println(index);
                if(data.getIsAdmin() == true) {
                    if (index == 0) {
                        dasboard = new Form_Dasboard();
                        setForm(dasboard);
                    } else if (index == 1) {
                        productList = new Form_ProductList();
                        setForm(productList);
                    }else if (index == 2) {
                        stackList = new Form_Stack();
                        setForm(stackList);
                    }else if (index == 3) {
                        warehouseList = new Form_Warehouse();
                        setForm(warehouseList);
                    }else if (index == 4) {
                        customer = new Form_Customer();
                        setForm(customer);
                    }else if(index == 5){
                        frLogin login = new frLogin();
                        login.setVisible(true);
                        Main.dispose();
                    }
                }else{
                    if (index == 0) {
                        dasboard = new Form_Dasboard();
                        setForm(dasboard);
                    } else if (index == 1) {
                        productList = new Form_ProductList();
                        setForm(productList);
                    }else if (index == 2) {
                        stackList = new Form_Stack();
                        setForm(stackList);
                    }else if (index == 3) {
                        warehouseList = new Form_Warehouse();
                        setForm(warehouseList);
                    }else if (index == 4) {
                        customer = new Form_Customer();
                        setForm(customer);
                    }else if(index == 5){
                        userList = new Form_User();
                        setForm(userList);
                    }else if(index == 6){
                        frLogin login = new frLogin();
                        login.setVisible(true);
                        Main.dispose();
                    }
                }
            }
        });
        //  set when system open start with home form
        setForm(new Form_Dasboard());
    }
    
    public void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderDas2 = new com.swing.panelBorderDas();
        menu = new com.component.Menu();
        mainPanel = new javax.swing.JPanel();
        frame_Welcome1 = new com.frame.Frame_Welcome();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorderDas2.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout panelBorderDas2Layout = new javax.swing.GroupLayout(panelBorderDas2);
        panelBorderDas2.setLayout(panelBorderDas2Layout);
        panelBorderDas2Layout.setHorizontalGroup(
            panelBorderDas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderDas2Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorderDas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frame_Welcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorderDas2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorderDas2Layout.setVerticalGroup(
            panelBorderDas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(panelBorderDas2Layout.createSequentialGroup()
                .addComponent(frame_Welcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderDas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderDas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.frame.Frame_Welcome frame_Welcome1;
    private javax.swing.JPanel mainPanel;
    private com.component.Menu menu;
    private com.swing.panelBorderDas panelBorderDas2;
    // End of variables declaration//GEN-END:variables
}
