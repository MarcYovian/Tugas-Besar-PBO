
package com.frame;

import com.model.StatusType;
import com.model.model_Card;
import com.model.model_Welcome;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Form_Dasboard extends javax.swing.JPanel {


    public Form_Dasboard() {
        initComponents();
        /* Welcome Message */
        welcome1.setData(new model_Welcome("Selamat Datang","Marcellinus Yovian","Di Warehouse Application!!!"));
        
        /* Card */
        card1.setData(new model_Card("Product", 20));
        card2.setData(new model_Card("Stack", 5));
        
        /* Table */
        spTabel.setVerticalScrollBar(new ScrollBar());
        spTabel.getVerticalScrollBar().setBackground(Color.WHITE);
        spTabel.getViewport().setBackground(Color.WHITE);   
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTabel.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tabel.addRow(new Object[]{1, "01", "Marcell","Sabun","1","02/02/21", StatusType.INCOMING});
        tabel.addRow(new Object[]{2, "02", "Marcell","Sabun","2","02/02/21", StatusType.OUTGOING});
        tabel.addRow(new Object[]{3, "03", "Marcell","Sabun","3","02/02/21", StatusType.TRANSFERRED});
        tabel.addRow(new Object[]{4, "04", "Marcell","Sabun","4","02/02/21", StatusType.RETURNED});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        welcome1 = new com.component.Welcome();
        jPanel1 = new javax.swing.JPanel();
        card1 = new com.component.card();
        card2 = new com.component.card();
        pnlTable = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spTabel = new javax.swing.JScrollPane();
        tabel = new com.swing.Tabel();

        setBackground(new java.awt.Color(252, 251, 246));
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/home-black.png"))); // NOI18N
        jLabel1.setText("Dasboard");

        welcome1.setBackground(new java.awt.Color(253, 253, 253));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        card1.setColor1(new java.awt.Color(247, 125, 2));
        card1.setColor2(new java.awt.Color(247, 167, 87));
        jPanel1.add(card1);

        card2.setColor1(new java.awt.Color(247, 206, 0));
        card2.setColor2(new java.awt.Color(250, 220, 72));
        jPanel1.add(card2);

        pnlTable.setBackground(new java.awt.Color(241, 241, 241));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(118, 118, 118));
        jLabel2.setText("History Warehouse");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_Pencatatan", "nama_Stack", "nama_User", "nama_Barang", "id_Pelanggan", "Tanggal", "Status"
            }
        ));
        spTabel.setViewportView(tabel);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTabel))
                .addContainerGap())
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.component.card card1;
    private com.component.card card2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JScrollPane spTabel;
    private com.swing.Tabel tabel;
    private com.component.Welcome welcome1;
    // End of variables declaration//GEN-END:variables
}
