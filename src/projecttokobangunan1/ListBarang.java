package projecttokobangunan1;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ListBarang extends javax.swing.JFrame {
 private DefaultTableModel model;
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
         try {
            Connection c = Koneksi.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM data_barang";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[4];
                o [0] = r.getString("kode_barang");
                o [1] = r.getString("nama_barang");
                o [2] = r.getString("harga_jual");
                o [3] = r.getString("stok");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    public void cari(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("kode_barang");
        tabel.addColumn("nama_barang");
        tabel.addColumn("harga_jual");
        tabel.addColumn("stok");
        
        try {
            Connection c = Koneksi.getConnection();
            String sql = "Select * from data_barang where kode_barang like '%" + txCari.getText() + "%'" +
                    "or nama_barang like '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                   
                });
            }
            jTable2.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }
  
    public ListBarang() {
        initComponents();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        model = new DefaultTableModel();
        
        jTable2.setModel(model);
        
        model.addColumn("Kode barang");
        model.addColumn("Nama barang");
        model.addColumn("Harga jual");
        model.addColumn("Stok");
        
        loadData();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        maximize = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txCari = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(58, 38, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 551));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_arrow_back_ios_black_24dp.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        minimize.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, 20));

        maximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_open_in_new_black_24dp.png"))); // NOI18N
        maximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeMouseClicked(evt);
            }
        });
        jPanel1.add(maximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_close_black_24dp.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("LIST DATA BARANG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jTable2.setBackground(new java.awt.Color(204, 204, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });
        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariKeyTyped(evt);
            }
        });

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel2.setText("CARI :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCari))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnPilih)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txCariActionPerformed

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txCariKeyTyped

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        
        String id = jTable2.getValueAt(i, 0).toString();
        String nama = jTable2.getValueAt(i, 1).toString();
        String harga = jTable2.getValueAt(i, 2).toString();
        
        Transaksi.txKODEBARANG.setText(id);
        Transaksi.txNAMABARANG.setText(nama);
        Transaksi.txHARGA.setText(harga);
        
        dispose();
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.setVisible(false);
        new Transaksi().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Loginbaru.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void maximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState()!=Loginbaru.MAXIMIZED_BOTH) {
            this.setExtendedState(Loginbaru.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(Loginbaru.NORMAL);
        }
    }//GEN-LAST:event_maximizeMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if (JOptionPane.showConfirmDialog(null,  "do you want to close the app?"," "
            ,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(ListBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel maximize;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}
