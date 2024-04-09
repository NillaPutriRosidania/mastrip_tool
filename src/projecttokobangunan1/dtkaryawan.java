package projecttokobangunan1;


import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;




public class dtkaryawan extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public dtkaryawan() {
        initComponents();
          load_table();
           kosong();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
           
    }
private void load_table(){
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("no");
    model.addColumn("Username");
    model.addColumn("Nama Karyawan");
    model.addColumn("Alamat");
    model.addColumn("Nomor Telepon");
    model.addColumn("Password");
    //menampilkan
    try {
        int no=1;
                String sql = "select * from data_karyawan join akun_karyawan on data_karyawan.kode_karyawan=akun_karyawan.username";
                java.sql.Connection conn=(Connection)config.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                while (res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),
                        res.getString(2),res.getString(3),res.getString(4),res.getString(6)});
                    
                }
              jTable2.setModel(model);
    }catch (Exception e){
        
    }
}

 private void kosong(){
    kode_krywn.enable();
    nama_txt.setText(null);
    alamat.setText(null);
    nomor.setText(null);
    pass.setText(null);
    }

         
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        maximize = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        kode_krywn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomor = new javax.swing.JTextField();
        nama_txt = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        icon2 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(58, 38, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 551));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("REGISTER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_arrow_back_ios_black_24dp.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_close_black_24dp.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, 40));

        maximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_open_in_new_black_24dp.png"))); // NOI18N
        maximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeMouseClicked(evt);
            }
        });
        jPanel1.add(maximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 30, 40));

        minimize.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 20, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(" USERNAME");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, 120, 23));

        kode_krywn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_krywnActionPerformed(evt);
            }
        });
        jPanel2.add(kode_krywn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 135, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText(" ALAMAT");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 26, 99, 23));

        nomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorActionPerformed(evt);
            }
        });
        jPanel2.add(nomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 120, -1));

        nama_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_txtActionPerformed(evt);
            }
        });
        jPanel2.add(nama_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 132, -1));

        nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama.setText(" NAMA KARYAWAN");
        nama.setToolTipText("");
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 99, 23));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText(" NOMOR TELEPON");
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 81, 120, 23));

        btn_tambah.setBackground(new java.awt.Color(120, 30, 190));
        btn_tambah.setText("TAMBAH");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 148, 82, -1));

        btn_hapus.setBackground(new java.awt.Color(120, 30, 190));
        btn_hapus.setText("HAPUS");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 182, 82, -1));

        btn_ubah.setBackground(new java.awt.Color(120, 30, 190));
        btn_ubah.setText("UBAH");
        btn_ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 182, 82, -1));

        btn_cetak.setBackground(new java.awt.Color(120, 30, 190));
        btn_cetak.setText("CETAK");
        btn_cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 148, 82, -1));

        jTable2.setBackground(new java.awt.Color(204, 204, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Nama Karyawan", "Alamat", "Nomor Telepon", "Password"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Username");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Nama Karyawan");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Alamat");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Nomor Telepon");
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Password");
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 210, 440, 214));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PASSWORD");
        jLabel6.setToolTipText("");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 81, 99, 23));

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });
        jPanel2.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 120, -1));
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 123, -1));

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_visibility_off_black_24dp.png"))); // NOI18N
        icon2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon2MousePressed(evt);
            }
        });
        jPanel2.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, 20));

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_visibility_black_24dp.png"))); // NOI18N
        icon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon1MousePressed(evt);
            }
        });
        jPanel2.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kode_krywnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_krywnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_krywnActionPerformed

    private void nomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorActionPerformed

    private void nama_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_txtActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
       try {
            String sqll = "INSERT INTO data_karyawan VALUES ('"+kode_krywn.getText()+"','"
                    +nama_txt.getText()+"','"+alamat.getText()+"','"+nomor.getText()+"')";
            String sql = "INSERT INTO akun_karyawan VALUES ('"+kode_krywn.getText()+"','"
                    +pass.getText()+"')";
            
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst= conn.prepareStatement(sql);
            java.sql.PreparedStatement pst1= conn.prepareStatement(sqll);
            
            pst.execute();
            pst1.execute();
            
            JOptionPane.showMessageDialog(null, "penyimpanan Berhasil");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
       try {
            String sql = "DELETE FROM data_karyawan where kode_karyawan='"+kode_krywn.getText()+"'";
           
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();                        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
         try {
            java.sql.Connection conn = (Connection)Koneksi.getConnection();
            InputStream report = getClass().getResourceAsStream("report1.jasper");
          

            JasperPrint jp = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        try {
            String sql = "UPDATE data_karyawan INNER JOIN akun_karyawan ON akun_karyawan.username=data_karyawan.kode_karyawan "
                    + "SET nama = '"+nama_txt.getText()+"' ,alamat = '"
                    +alamat.getText()+"' ,no_hp= '"
                    +nomor.getText()+"' ,password= '"+pass.getText()
                    +"'WHERE data_karyawan.kode_karyawan = '"+kode_krywn.getText()+"'";
            
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "data berhasil di ubah");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "perubahan data gagal"
            +e.getMessage());
        }
        load_table();
        kosong();                                 

    }//GEN-LAST:event_btn_ubahActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      this.setVisible(false);
       new MENU().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
     if (JOptionPane.showConfirmDialog(null,  "do you want to close the app?"," "
                ,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void maximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState()!=Loginbaru.MAXIMIZED_BOTH) {
            this.setExtendedState(Loginbaru.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(Loginbaru.NORMAL);
        }
    }//GEN-LAST:event_maximizeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Loginbaru.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         int baris = jTable2.rowAtPoint(evt.getPoint());
        String kode = jTable2.getValueAt(baris, 1).toString();
        kode_krywn.setText(kode);
        kode_krywn.disable();
        if (jTable2.getValueAt(baris, 2)== null) {
            nama_txt.setText("");
        } else {
            nama_txt.setText(jTable2.getValueAt(baris, 2).toString());
        } if (jTable2.getValueAt(baris, 3)==null) {
            alamat.setText("");
        } else {
            alamat.setText(jTable2.getValueAt(baris, 3).toString());
        } if (jTable2.getValueAt(baris, 4)==null) {
            nomor.setText("");
        } else {
           nomor.setText(jTable2.getValueAt(baris, 4).toString()); 
        }if (jTable2.getValueAt(baris, 5)==null) {
            pass.setText("");
        } else {
           pass.setText(jTable2.getValueAt(baris, 5).toString()); 
        }
    
        
  
    }//GEN-LAST:event_jTable2MouseClicked

    private void icon2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon2MousePressed
        icon1.setVisible(true);
        icon2.setVisible(false);
        pass.setEchoChar('*');
    }//GEN-LAST:event_icon2MousePressed

    private void icon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MousePressed
        icon2.setVisible(true);
        icon1.setVisible(false);
        pass.setEchoChar((char)0);
    }//GEN-LAST:event_icon1MousePressed

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
            java.util.logging.Logger.getLogger(dtkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dtkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dtkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dtkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new dtkaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField kode_krywn;
    private javax.swing.JLabel maximize;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel nama;
    private javax.swing.JTextField nama_txt;
    private javax.swing.JTextField nomor;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
