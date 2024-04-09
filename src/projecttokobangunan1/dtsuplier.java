package projecttokobangunan1;

import java.awt.Dimension;
import java.awt.Toolkit;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class dtsuplier extends javax.swing.JFrame {
     
     Koneksi koneksi = new Koneksi();
    
    private DefaultTableModel model;

    private void autonumber(){
        try {
            Connection c = Koneksi.getConnection();
            java.sql.Statement s = c.createStatement();
            String sql = "SELECT * FROM data_supplier ORDER BY kode_supplier DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kode_supplier").substring(2);
                String BR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if (BR.length()==1) 
                    {Nol = "00";}
                else if(BR.length()==2)
                    {Nol = "0";}
                else if(BR.length()==3)
                    {Nol = "";}
                
                kode_supplier.setText("SP" + Nol + BR);  
            }else{
                kode_supplier.setText("SP001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    
  
public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = Koneksi.getConnection();
            java.sql.Statement s = c.createStatement();
            
            String sql = "SELECT * FROM data_supplier";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[4];
                o [0] = r.getString("kode_supplier");
                o [1] = r.getString("nama_supplier");
                o [2] = r.getString("alamat");
                o [3] = r.getString("no_hp");
             
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("salah cok");
        }
    }
   
    public dtsuplier() {
        initComponents();
           
           
         // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        
      model = new DefaultTableModel();
        
        tabel12.setModel(model);
        
        model.addColumn("Kode Supplier");
        model.addColumn("Nama_Supplier");
        model.addColumn("Alamat");
        model.addColumn("No hp");
      
        
        loadData();
        autonumber();
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        maximize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        kode_supplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        nama_supplier = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomor_telp = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel12 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_Cari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(58, 38, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 551));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DATA SUPPLIER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

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
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 4, -1, 30));

        minimize.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 20, 30));

        maximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_open_in_new_black_24dp.png"))); // NOI18N
        maximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeMouseClicked(evt);
            }
        });
        jPanel1.add(maximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 40));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText(" KODE SUPPLIER");
        jLabel2.setToolTipText("");

        kode_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_supplierActionPerformed(evt);
            }
        });

        jLabel3.setText(" ALAMAT");
        jLabel3.setToolTipText("");

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        nama_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_supplierActionPerformed(evt);
            }
        });

        jLabel5.setText(" NAMA SUPPLIER");
        jLabel5.setToolTipText("");

        jLabel4.setText(" NOMOR TELEPON");
        jLabel4.setToolTipText("");

        nomor_telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomor_telpActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(120, 30, 190));
        btn_tambah.setText("TAMBAH");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(120, 30, 190));
        btn_hapus.setText("HAPUS");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(120, 30, 190));
        btn_ubah.setText("UBAH");
        btn_ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_cetak.setBackground(new java.awt.Color(120, 30, 190));
        btn_cetak.setText("CETAK");
        btn_cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kode_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomor_telp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_cetak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomor_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_cetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel12.setBackground(new java.awt.Color(204, 204, 255));
        tabel12.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        tabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel12MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel12);

        jLabel7.setText("CARI  :");

        txt_Cari.setText(" ");
        txt_Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CariActionPerformed(evt);
            }
        });
        txt_Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Cari)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kode_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_supplierActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void nama_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_supplierActionPerformed

    private void nomor_telpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomor_telpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomor_telpActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String kd = kode_supplier.getText();
        String nama = nama_supplier.getText();
        String alamat1 = alamat.getText();
        String nomor = nomor_telp.getText();
       

        try {
            Connection c = Koneksi.getConnection();
            String sql = "INSERT INTO data_supplier VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kd);
            p.setString(2, nama);
            p.setString(3, alamat1);
            p.setString(4, nomor);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }finally{
            autonumber();
          
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
         try {
            String sql ="DELETE FROM data_supplier WHERE kode_supplier= '"+kode_supplier.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
          try {
            java.sql.Connection conn = (Connection)Koneksi.getConnection();
            InputStream report = getClass().getResourceAsStream("reportsupplier.jasper");
          

            JasperPrint jp = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.setVisible(false);
       new MENU().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
     if (JOptionPane.showConfirmDialog(null, "do you want to close the app?"," "
                ,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel19MouseClicked

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

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
                try {
            String sql ="UPDATE data_supplier "+ "SET nama_supplier='"+nama_supplier.getText()+"',alamat='"+alamat.getText()+"',"
                         + "no_hp='"+nomor_telp.getText()+"'" + "WHERE kode_supplier='"+kode_supplier.getText()+"'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan data gagal"
            +e.getMessage());
        }
        
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void tabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel12MouseClicked
  
        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
      
        int i = tabel12.getSelectedRow();
        if (i == -1) {
            return;
        }

        String kd = (String) model.getValueAt(i, 0);
        String nama = (String) model.getValueAt(i, 1);
        String almt= (String) model.getValueAt(i, 2);
        String nomortlp = (String) model.getValueAt(i, 3);
     
        kode_supplier.setText(kd);
        nama_supplier.setText(nama);
        alamat.setText(almt);
        nomor_telp.setText(nomortlp);
      
    }//GEN-LAST:event_tabel12MouseClicked

    private void txt_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CariActionPerformed
    }//GEN-LAST:event_txt_CariActionPerformed

    private void txt_CariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CariKeyTyped
       
    }//GEN-LAST:event_txt_CariKeyTyped

    private void txt_CariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CariKeyReleased
String [] judul = {"kode_supplier","nama_supplier","alamat","no_hp"};
        model = new DefaultTableModel(judul,0);
        tabel12.setModel(model);
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastrip_tool","root","");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM data_supplier WHERE CONCAT (nama_supplier) LIKE '%"+txt_Cari.getText()+"%'");
            while(rs.next()){
                String data [] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                model.addRow(data);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(dtsuplier.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_txt_CariKeyReleased

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
            java.util.logging.Logger.getLogger(dtsuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dtsuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dtsuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dtsuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dtsuplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kode_supplier;
    private javax.swing.JLabel maximize;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField nama_supplier;
    private javax.swing.JTextField nomor_telp;
    private javax.swing.JTable tabel12;
    private javax.swing.JTextField txt_Cari;
    // End of variables declaration//GEN-END:variables
}
