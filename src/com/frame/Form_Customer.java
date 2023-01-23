package com.frame;

import com.actionTableAdmin.TableActionCellEditor;
import com.actionTableAdmin.TableActionEvent;
import com.actionTableAdmin.tableActionCellRender;
import com.connection.DatabaseConnection;
import com.dataStorage.editCust;
import static com.dataStorage.editCust.getInstance;
import com.glasspane.popup.warehouse.Edit_Warehouse;
import com.glasspanepopup.Customer.Edit_Customer;
import com.glasspanepopup.Customer.insertCust;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.main.Main;
import com.swing.ScrollBar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import swinger.glasspanepopup.GlassPanePopup;

public class Form_Customer extends javax.swing.JPanel {

    ResultSet rs;
    private editCust data;
    
    public Form_Customer() {
        initComponents();
        
        data = editCust.getInstance();
        spTabel.setVerticalScrollBar(new ScrollBar());
        spTabel.getVerticalScrollBar().setBackground(Color.WHITE);
        spTabel.getViewport().setBackground(Color.WHITE);   
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTabel.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                DefaultTableModel model = (DefaultTableModel) tabel.getModel();
                //set data
                data.setId(Integer.parseInt((String) model.getValueAt(row, 0)));
                data.setNama((String) model.getValueAt(row, 1));
                data.setAlamat((String) model.getValueAt(row, 2));
                data.setEmail((String) model.getValueAt(row, 3));
                data.setNomer((String) model.getValueAt(row, 4));
                data.setIsSupplier(Integer.parseInt((String) model.getValueAt(row, 5)));
                
                //switch panel Edit_Customer
                Edit_Customer edit = new Edit_Customer();
                Main main = (Main) SwingUtilities.getWindowAncestor(Form_Customer.this);
                main.setForm(edit);
            }
        };
        tabel.getColumnModel().getColumn(6).setCellRenderer(new tableActionCellRender());
        tabel.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertCust insert = new insertCust();
                Main main = (Main) SwingUtilities.getWindowAncestor(Form_Customer.this);
                main.setForm(insert);
            }
        });
        
        search1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    
                }
            }
            
        });
        
        try {
            DatabaseConnection db = new DatabaseConnection();
            rs = db.getData("SELECT * FROM pelanggan");
            
            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            while(rs.next()){
                String[] args = {
                    rs.getString("id_Pelanggan"),
                    rs.getString("nama_Pelanggan"),
                    rs.getString("alamat"),
                    rs.getString("email"),
                    rs.getString("no_telepon"),
                    rs.getString("isSupplier"),
                };
                model.addRow(args);
            }
            rs.close();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        search1 = new com.component.Search();
        btnTambah = new com.swing.MyButton();
        jPanel1 = new javax.swing.JPanel();
        spTabel = new javax.swing.JScrollPane();
        tabel = new com.swing.TabelListCust();

        setBackground(new java.awt.Color(252, 251, 246));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/customer.png"))); // NOI18N
        jLabel1.setText("Customer List");

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 30.0;
        gridBagConstraints.weighty = 0.8;
        jPanel2.add(search1, gridBagConstraints);

        btnTambah.setText("Tambah Customer");
        btnTambah.setMaximumSize(new java.awt.Dimension(150, 26));
        btnTambah.setMinimumSize(new java.awt.Dimension(100, 26));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.ipadx = 33;
        jPanel2.add(btnTambah, gridBagConstraints);
        btnTambah.setBackground(new Color(255,153,102));
        btnTambah.setForeground(new Color(250, 250, 250));
        btnTambah.setText("Tambah Barang");
        btnTambah.setFont(new java.awt.Font("Poppins", 0, 13));

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nama", "Alamat", "Email", "Telepon", "Supplier", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setSelectionBackground(new java.awt.Color(255, 255, 255));
        spTabel.setViewportView(tabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(spTabel)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(spTabel)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed

    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.MyButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.component.Search search1;
    private javax.swing.JScrollPane spTabel;
    private com.swing.TabelListCust tabel;
    // End of variables declaration//GEN-END:variables
}
