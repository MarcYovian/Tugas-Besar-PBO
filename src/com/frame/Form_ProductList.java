
package com.frame;

import com.actionTableProduct.TableActionCellEditor;
import com.actionTableProduct.TableActionEvent;
import com.actionTableProduct.tableActionCellRender;
import com.connection.DatabaseConnection;
import com.dataStorage.editProduct;
import com.glasspanepopup.Barang.DS_1;
import static com.glasspanepopup.Barang.DS_1.getInstance;
import com.glasspanepopup.Barang.Edit_Product;
import com.glasspanepopup.Barang.Exited_Product;
import com.glasspanepopup.Barang.insertProduct;
import com.glasspanepopup.model.Model_Message;
import com.glasspanepopup.popup.Message;
import com.insert.PopupInsert;
import com.insert.popUp;
import com.main.Main;
import com.model.StatusType;
import com.swing.ScrollBar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import swinger.glasspanepopup.GlassPanePopup;

public class Form_ProductList extends javax.swing.JPanel {
    
    private DS_1 data;
    private editProduct dataEdit;  
    ResultSet rs;
    
    public Form_ProductList() {
        initComponents();
       
        spTabel.setVerticalScrollBar(new ScrollBar());
        spTabel.getVerticalScrollBar().setBackground(Color.WHITE);
        spTabel.getViewport().setBackground(Color.WHITE);   
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTabel.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                dataEdit = editProduct.getInstance();
                DefaultTableModel model = (DefaultTableModel) tabel.getModel();
                int idProduct = Integer.parseInt((String) model.getValueAt(row, 0));
                int idRak = Integer.parseInt((String) model.getValueAt(row, 1));
                String namaBarang = (String) model.getValueAt(row, 2);
                String kategori = (String) model.getValueAt(row, 3);
                int jumlah = Integer.parseInt((String) model.getValueAt(row, 4));
                String deskripsi = (String) model.getValueAt(row, 5);
                
                DatabaseConnection db =new DatabaseConnection();
                rs = db.getData("SELECT * FROM pencatatan WHERE id_Rak = '" + idRak + "' AND id_Barang = '" + idProduct + "'");
                String date = null;
                String status = null;
                int idPelanggan = 0;
                try {
                    if (rs.next()) {
                        date = rs.getString("tanggal");
                        status = rs.getString("status");
                        idPelanggan =rs.getInt("id_Pelanggan");
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Form_ProductList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(idProduct + " " + idRak + " " + namaBarang +  " " + idPelanggan + " " + kategori + " " + jumlah + " " + deskripsi + " " + date + " " + status);
                
                dataEdit.setIdBarang(idProduct);
                dataEdit.setIdRak(idRak);
                dataEdit.setNamaBarang(namaBarang);
                dataEdit.setIdPelanggan(idPelanggan);
                dataEdit.setKategori(kategori);
                dataEdit.setJumlah(jumlah);
                dataEdit.setDeskripsi(deskripsi);
                dataEdit.setDate(date);
                dataEdit.setStatus(StatusType.valueOf(status));
                
                Edit_Product edit = new Edit_Product();
                Main main = (Main) SwingUtilities.getWindowAncestor(Form_ProductList.this);
                main.setForm(edit);
            }

            @Override
            public void onExited(int row) {
                dataEdit = editProduct.getInstance();
                DefaultTableModel model = (DefaultTableModel) tabel.getModel();
                int idProduct = Integer.parseInt((String) model.getValueAt(row, 0));
                int idRak = Integer.parseInt((String) model.getValueAt(row, 1));
                String namaBarang = (String) model.getValueAt(row, 2);
                String kategori = (String) model.getValueAt(row, 3);
                int jumlah = Integer.parseInt((String) model.getValueAt(row, 4));
                String deskripsi = (String) model.getValueAt(row, 5);
                
                DatabaseConnection db =new DatabaseConnection();
                rs = db.getData("SELECT * FROM pencatatan WHERE id_Rak = '" + idRak + "' AND id_Barang = '" + idProduct + "'");
                String date = null;
                String status = null;
                int idPelanggan = 0;
                try {
                    if (rs.next()) {
                        date = rs.getString("tanggal");
                        status = rs.getString("status");
                        idPelanggan =rs.getInt("id_Pelanggan");
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Form_ProductList.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(idProduct + " " + idRak + " " + namaBarang +  " " + idPelanggan + " " + kategori + " " + jumlah + " " + deskripsi + " " + date + " " + status);
                
                dataEdit.setIdBarang(idProduct);
                dataEdit.setIdRak(idRak);
                dataEdit.setNamaBarang(namaBarang);
                dataEdit.setIdPelanggan(idPelanggan);
                dataEdit.setKategori(kategori);
                dataEdit.setJumlah(jumlah);
                dataEdit.setDeskripsi(deskripsi);
                dataEdit.setDate(date);
                dataEdit.setStatus(StatusType.valueOf(status));
                
                Exited_Product edit = new Exited_Product();
                Main main = (Main) SwingUtilities.getWindowAncestor(Form_ProductList.this);
                main.setForm(edit);
            }
        };
        tabel.getColumnModel().getColumn(6).setCellRenderer(new tableActionCellRender());
        tabel.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertProduct insert = new insertProduct();
                Main main = (Main) SwingUtilities.getWindowAncestor(Form_ProductList.this);
                main.setForm(insert);
            }
        });
        
        try {
            DatabaseConnection db =new DatabaseConnection();
            rs = db.getData("SELECT * FROM barang WHERE isDeleted = 0");
            
            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            while (rs.next()) {                
                String[] args = {
                    rs.getString("id_Barang"),
                    rs.getString("id_Rak"),
                    rs.getString("nama_Barang"),
                    rs.getString("kategori_Barang"),
                    rs.getString("jumlah"),
                    rs.getString("deskripsi")
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
        jPanel1 = new javax.swing.JPanel();
        spTabel = new javax.swing.JScrollPane();
        tabel = new com.swing.TabelListBarang();
        jPanel2 = new javax.swing.JPanel();
        search1 = new com.component.Search();
        btnTambah = new com.swing.MyButton();

        setBackground(new java.awt.Color(252, 251, 246));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/package-Black.png"))); // NOI18N
        jLabel1.setText("Product List");

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_Product", "id_Stack", "nama_Barang", "jenis_Barang", "Jumlah", "Deskripsi", "Action"
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
                .addComponent(spTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(spTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 30.0;
        gridBagConstraints.weighty = 0.8;
        jPanel2.add(search1, gridBagConstraints);

        btnTambah.setText("Tambah Barang");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
    private com.swing.TabelListBarang tabel;
    // End of variables declaration//GEN-END:variables
}
