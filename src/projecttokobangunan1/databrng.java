package projecttokobangunan1;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class databrng extends javax.swing.JFrame {

  
     Koneksi koneksi = new Koneksi();
    
    private DefaultTableModel model;

    private void autonumber(){
        try {
            Connection c = koneksi.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM data_barang ORDER BY kode_barang DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kode_barang").substring(2);
                String BR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if (BR.length()==1) 
                    {Nol = "00";}
                else if(BR.length()==2)
                    {Nol = "0";}
                else if(BR.length()==3)
                    {Nol = "";}
                
                txt_kdbrng.setText("BR" + Nol + BR);  
            }else{
                txt_kdbrng.setText("BR001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
      public void clear(){
        txt_namabrg.setText("");
        txt_hargabeli.setText("");
        txt_hargajual1.setText("");
        txt_stokbrg.setText("");
    }
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = Koneksi.getConnection();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM data_barang";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[6];
                o [0] = r.getString("kode_barang");
                o [1] = r.getString("nama_barang");
                o [2] = r.getString("kode_supplier");
                o [3] = r.getString("harga_beli");
                o [4] = r.getString("harga_jual");
                o [5] = r.getString("stok");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("salah cok");
        }
    }
    
    public void cariData(){
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("Kode_barang");
        tabel.addColumn("nama_barang");
        tabel.addColumn("kode_supplier");
        tabel.addColumn("harga_beli");
        tabel.addColumn("harga_jual");
        tabel.addColumn("stok");
        
        try {
            Connection c = koneksi.getConnection();
            String sql = "Select * from data_barang where kode_barang like '%" + cari.getText() + "%'" +
                    "or nama_barang like '%" + cari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                 
                   
                });
            }
            jtabel1.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }
    public databrng() {
        initComponents();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
       model = new DefaultTableModel();
        
        jtabel1.setModel(model);
        
       
        model.addColumn("kode_barang");
        model.addColumn("nama_barang");
        model.addColumn("kode_supplier");
        model.addColumn("harga_beli");
        model.addColumn("harga_jual");
        model.addColumn("stok");
        
        loadData();
        autonumber();
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_batal.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        maximize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_namabrg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hargabeli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_kdbrng = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_stokbrg = new javax.swing.JTextField();
        txt_hargajual1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_supplier1 = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabel1 = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 38, 249));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("DATA BARANG");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_arrow_back_ios_black_24dp.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_close_black_24dp.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        minimize.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        maximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_open_in_new_black_24dp.png"))); // NOI18N
        maximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maximize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addComponent(maximize, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 60));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText(" NAMA BARANG");
        jLabel2.setToolTipText("");

        txt_namabrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabrgActionPerformed(evt);
            }
        });

        jLabel3.setText(" HARGA JUAL");
        jLabel3.setToolTipText("");

        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });

        jLabel4.setText("  KODE BARANG");
        jLabel4.setToolTipText("");

        txt_kdbrng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdbrngActionPerformed(evt);
            }
        });

        jLabel5.setText(" STOK BARANG");
        jLabel5.setToolTipText("");

        jLabel6.setText(" HARGA BELI");
        jLabel6.setToolTipText("");

        txt_stokbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokbrgActionPerformed(evt);
            }
        });

        txt_hargajual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajual1ActionPerformed(evt);
            }
        });

        jLabel11.setText("SUPLIER");
        jLabel11.setToolTipText("");

        txt_supplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_supplier1ActionPerformed(evt);
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

        btn_batal.setBackground(new java.awt.Color(120, 30, 190));
        btn_batal.setText("BATAL");
        btn_batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
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

        btn_hapus.setBackground(new java.awt.Color(120, 30, 190));
        btn_hapus.setText("HAPUS");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
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
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_kdbrng, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_stokbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_hargajual1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_supplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cetak)
                .addGap(232, 232, 232))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdbrng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stokbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hargajual1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_batal)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btn_cetak)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 540, 230));

        jLabel7.setText("CARI BARANG :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 20));

        cari.setText(" ");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 360, -1));

        jtabel1.setBackground(new java.awt.Color(204, 204, 255));
        jtabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "kode", "Nama", "Stok", "Harga Beli", "Harga Jual", "Suplier", "Title 7"
            }
        ));
        jtabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabel1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 540, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_namabrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabrgActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void txt_kdbrngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdbrngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdbrngActionPerformed

    private void txt_stokbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokbrgActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
          try {
            java.sql.Connection conn = (Connection)Koneksi.getConnection();
            InputStream report = getClass().getResourceAsStream("reportBARANG.jasper");
          

            JasperPrint jp = JasperFillManager.fillReport(report, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String kd = txt_kdbrng.getText();
        String nama = txt_namabrg.getText();
        String kd_supplier = txt_supplier1.getText();
        String hargaBeli = txt_hargabeli.getText();
        String hargaJual = txt_hargajual1.getText();
        String stok = txt_stokbrg.getText();

        try {
            Connection c = Koneksi.getConnection();
            String sql = "INSERT INTO data_barang VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kd);
            p.setString(2, nama);
            p.setString(3, kd_supplier);
            p.setString(4, hargaBeli);
            p.setString(5, hargaJual);
            p.setString(6, stok);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }finally{
            autonumber();
            clear();
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int i = jtabel1.getSelectedRow();
        if (i == -1) {
            return;
        }

        String id = (String) model.getValueAt(i, 0);

        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus","Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan== JOptionPane.OK_OPTION) {
            try {
                Connection c = koneksi.getConnection();
                String sql = "DELETE FROM data_barang WHERE kode_barang = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            }finally{
                btn_tambah.setEnabled(true);
                btn_ubah.setEnabled(false);
                btn_hapus.setEnabled(false);
                btn_batal.setEnabled(false);
                loadData();
                autonumber();
                clear();
            }
        }
        if (pernyataan== JOptionPane.CANCEL_OPTION) {

        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       this.setVisible(false);
       new MENU().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
      if (JOptionPane.showConfirmDialog(null,  "do you want to close the app?"," "
                ,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

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

    private void txt_hargajual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajual1ActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
          clear();
        loadData();
        btn_tambah.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_batal.setEnabled(false);
        autonumber();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
         int i = jtabel1.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kd = (String) model.getValueAt(i, 0);
        String nama = txt_namabrg.getText();
        String kd_supplier =txt_supplier1.getText();
        String hargaBeli = txt_hargabeli.getText();
        String hargaJual = txt_hargajual1.getText();
        String stok = txt_stokbrg.getText();

        try {
            Connection c = koneksi.getConnection();
            String sql = "UPDATE data_barang SET nama_barang = ?, kode_supplier = ?, harga_beli = ?, harga_jual = ?, stok = ? WHERE kode_barang = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, kd_supplier);
            p.setString(3, hargaBeli);
            p.setString(4, hargaJual);
            p.setString(5, stok);
            p.setString(6, kd);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Terubah");
            btn_tambah.setEnabled(true);
            btn_ubah.setEnabled(false);
            btn_hapus.setEnabled(false);
            btn_batal.setEnabled(false);
            clear();
        } catch (Exception e) {
            System.out.println("update error");
        }finally{
            loadData();
            autonumber();
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
    cariData();

    }//GEN-LAST:event_cariActionPerformed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped
    cariData();
    }//GEN-LAST:event_cariKeyTyped

    private void jtabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabel1MouseClicked
          btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_batal.setEnabled(true);

        int i = jtabel1.getSelectedRow();
        if (i == -1) {
            return;
        }

        String kd = (String) model.getValueAt(i, 0);
        String nama = (String) model.getValueAt(i, 1);
        String kd_supplier= (String) model.getValueAt(i, 2);
        String hargaBeli = (String) model.getValueAt(i, 3);
        String hargaJual = (String) model.getValueAt(i, 4);
        String stok = (String) model.getValueAt(i, 5);

        txt_kdbrng.setText(kd);
        txt_namabrg.setText(nama);
        txt_supplier1.setText(kd_supplier);
        txt_hargabeli.setText(hargaBeli);
        txt_hargajual1.setText(hargaJual);
        txt_stokbrg.setText(stok);
    }//GEN-LAST:event_jtabel1MouseClicked

    private void txt_supplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplier1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplier1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(databrng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(databrng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(databrng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(databrng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databrng().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JTextField cari;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabel1;
    private javax.swing.JLabel maximize;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField txt_hargabeli;
    private javax.swing.JTextField txt_hargajual1;
    private javax.swing.JTextField txt_kdbrng;
    private javax.swing.JTextField txt_namabrg;
    private javax.swing.JTextField txt_stokbrg;
    private javax.swing.JTextField txt_supplier1;
    // End of variables declaration//GEN-END:variables
}
