package projecttokobangunan1;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;


public class Transaksi extends javax.swing.JFrame {
 String Tanggal;
    private DefaultTableModel model;
    
    public void totalBiaya(){
        int jumlahBaris = jTable1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txtTOTALBAYAR.setText(String.valueOf(totalBiaya));
        txTampil.setText("Rp "+ totalBiaya +",00");
    }
    
    private void autonumber(){
        try {
            Connection c = Koneksi.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY kode_transaksi DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String kode_transaksi = r.getString("kode_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(kode_transaksi)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txKODETRANSAKSI.setText("TR" + Nol + TR);
            } else {
                txKODETRANSAKSI.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error cok");
        }
    }
    private void autonumber1(){
        try {
            Connection c = Koneksi.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY id_pelanggan DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String IDPELANGGAN = r.getString("id_pelanggan").substring(2);
                String TR = "" +(Integer.parseInt(IDPELANGGAN)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                txIDPELANGGAN2.setText("ID" + Nol + TR);
            } else {
                txIDPELANGGAN2.setText("ID0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber 1 error cok");
        }
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            txKODETRANSAKSI.getText(),
            txKODEBARANG.getText(),
            txNAMABARANG.getText(),
            txJUMLAH.getText(),
            txHARGA.getText(),
            txtTOTALBAYAR.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txKODETRANSAKSI.setText("");
        txKODEBARANG.setText("");
        txNAMABARANG.setText("");
        txHARGA.setText("");
        txJUMLAH.setText("");
        autonumber();//ikineh
        autonumber1();
    }
    
    public void clear(){
      
        txtTOTALBAYAR.setText("0");
        txBAYAR.setText("0");
        txKEMBALIAN.setText("0");
        txTampil.setText("0");
    }
    
    public void clear2(){
        txKODEBARANG.setText("");
        txNAMABARANG.setText("");
        txHARGA.setText("");
        txJUMLAH.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txJUMLAH.getText());
        harga = Integer.valueOf(txHARGA.getText());
        total = jumlah * harga;
        
        txtTOTALBAYAR.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        txKODEBARANG.requestFocus();
    }
    
    public Transaksi() {
        initComponents();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
           model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("Kode TR");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txTGLTRANSAKSI.setText(s.format(date));
        txtTOTALBAYAR.setText("0");
        txBAYAR.setText("0");
        txKEMBALIAN.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        maximize = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BTN_TAMBAH = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txKODETRANSAKSI = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txJUMLAH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txNAMABARANG = new javax.swing.JTextField();
        txKODEBARANG = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        BTN_HAPUS = new javax.swing.JButton();
        txHARGA = new javax.swing.JTextField();
        Caribarang = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txNAMAPELANGGAN = new javax.swing.JTextField();
        BTN_SIMPAN = new javax.swing.JButton();
        txIDPELANGGAN2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        admin_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txTGLTRANSAKSI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTOTALBAYAR = new javax.swing.JTextField();
        txBAYAR = new javax.swing.JTextField();
        txKEMBALIAN = new javax.swing.JTextField();
        txTampil = new javax.swing.JTextField();
        BTN_CETAK = new javax.swing.JButton();
        txtCetak = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(58, 38, 249));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" TRANSAKSI");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_arrow_back_ios_black_24dp.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/outline_close_black_24dp.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        maximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_close_fullscreen_black_24dp.png"))); // NOI18N
        maximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeMouseClicked(evt);
            }
        });

        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projecttokobangunan/baseline_minimize_black_24dp.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maximize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(maximize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(minimize)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        BTN_TAMBAH.setBackground(new java.awt.Color(120, 30, 190));
        BTN_TAMBAH.setText("TAMBAH");
        BTN_TAMBAH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_TAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_TAMBAHActionPerformed(evt);
            }
        });

        jLabel14.setText(" KODE TRANSAKSI ");
        jLabel14.setToolTipText("");

        txKODETRANSAKSI.setEnabled(false);
        txKODETRANSAKSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKODETRANSAKSIActionPerformed(evt);
            }
        });

        jLabel15.setText("ID PELANGGAN");
        jLabel15.setToolTipText("");

        txJUMLAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJUMLAHActionPerformed(evt);
            }
        });

        jLabel16.setText("NAMA BARANG");
        jLabel16.setToolTipText("");

        jLabel17.setText("JUMLAH");
        jLabel17.setToolTipText("");

        txNAMABARANG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNAMABARANGActionPerformed(evt);
            }
        });

        txKODEBARANG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKODEBARANGActionPerformed(evt);
            }
        });

        jLabel18.setText("HARGA");
        jLabel18.setToolTipText("");

        BTN_HAPUS.setBackground(new java.awt.Color(120, 30, 190));
        BTN_HAPUS.setText("HAPUS");
        BTN_HAPUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HAPUSActionPerformed(evt);
            }
        });

        txHARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHARGAActionPerformed(evt);
            }
        });

        Caribarang.setBackground(new java.awt.Color(120, 30, 190));
        Caribarang.setText("CARI BARANG");
        Caribarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Caribarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaribarangActionPerformed(evt);
            }
        });

        jLabel20.setText(" KODE BARANG");
        jLabel20.setToolTipText("");

        txNAMAPELANGGAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNAMAPELANGGANActionPerformed(evt);
            }
        });

        BTN_SIMPAN.setBackground(new java.awt.Color(120, 30, 190));
        BTN_SIMPAN.setText("SIMPAN");
        BTN_SIMPAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPANActionPerformed(evt);
            }
        });

        txIDPELANGGAN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIDPELANGGAN2ActionPerformed(evt);
            }
        });

        jLabel22.setText("NAMA PELANGGAN");
        jLabel22.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_TAMBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_SIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_HAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txNAMAPELANGGAN, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txIDPELANGGAN2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Caribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txKODETRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txKODEBARANG, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txNAMABARANG, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txHARGA, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txJUMLAH, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txKODETRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txIDPELANGGAN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txNAMAPELANGGAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txKODEBARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txNAMABARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txHARGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txJUMLAH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caribarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_TAMBAH)
                    .addComponent(BTN_SIMPAN))
                .addGap(18, 18, 18)
                .addComponent(BTN_HAPUS)
                .addContainerGap())
        );

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setText("ADMIN");

        admin_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_txt.setEnabled(false);
        admin_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_txtMouseClicked(evt);
            }
        });
        admin_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_txtActionPerformed(evt);
            }
        });

        jLabel13.setText("TANGGAL TRANSAKSI");

        txTGLTRANSAKSI.setEnabled(false);
        txTGLTRANSAKSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTGLTRANSAKSIActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "KODE BRG", "NAMA", "JUMLAH", "HARGA", "HARGA TOTAL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setText("TOTAL BAYAR");
        jLabel9.setToolTipText("");

        jLabel10.setText("BAYAR");
        jLabel10.setToolTipText("");

        jLabel11.setText("KEMBALIAN");
        jLabel11.setToolTipText("");

        txtTOTALBAYAR.setEnabled(false);

        txBAYAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBAYARActionPerformed(evt);
            }
        });

        txKEMBALIAN.setEnabled(false);
        txKEMBALIAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKEMBALIANActionPerformed(evt);
            }
        });

        txTampil.setBackground(new java.awt.Color(255, 153, 153));
        txTampil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txTampil.setText("Rp. 0");
        txTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTampilActionPerformed(evt);
            }
        });

        BTN_CETAK.setBackground(new java.awt.Color(120, 30, 190));
        BTN_CETAK.setText("CETAK");
        BTN_CETAK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_CETAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CETAKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(admin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txTGLTRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txKEMBALIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTOTALBAYAR))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txBAYAR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(BTN_CETAK, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(admin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txTGLTRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTOTALBAYAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBAYAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txKEMBALIAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_CETAK)
                    .addComponent(txtCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_TAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_TAMBAHActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_BTN_TAMBAHActionPerformed

    private void txKODETRANSAKSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKODETRANSAKSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKODETRANSAKSIActionPerformed

    private void txJUMLAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJUMLAHActionPerformed
              tambahTransaksi();
    }//GEN-LAST:event_txJUMLAHActionPerformed

    private void txNAMABARANGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNAMABARANGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNAMABARANGActionPerformed

    private void txKODEBARANGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKODEBARANGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKODEBARANGActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txBAYAR.setText("0");
        txKEMBALIAN.setText("0");
        //HashedMap hash =new HashedMap();
              //hash.put("KODE",txtCetak.getText());
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_CETAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CETAKActionPerformed
          try {
            java.sql.Connection conn = (Connection)Koneksi.getConnection();
            InputStream report = getClass().getResourceAsStream("NOTA1.jasper");
             HashedMap hash =new HashedMap();
            hash.put("KODE",txtCetak.getText());

            JasperPrint jp = JasperFillManager.fillReport(report,hash , conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_BTN_CETAKActionPerformed

    private void txHARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHARGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHARGAActionPerformed

    private void admin_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_txtActionPerformed

    private void txTGLTRANSAKSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTGLTRANSAKSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTGLTRANSAKSIActionPerformed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String kodeTransaksi = txKODETRANSAKSI.getText();
        String idpelanggan= txIDPELANGGAN2.getText();
        String total = txtTOTALBAYAR.getText();
        String tanggal = txTGLTRANSAKSI.getText();
        String namapelanggan= txNAMAPELANGGAN.getText();
        String admin= admin_txt.getText();
        String kembalian= txKEMBALIAN.getText();
        String bayar= txBAYAR.getText();
   
        
        
      try {
            Connection c = Koneksi.getConnection();
            String sql = "INSERT INTO transaksi VALUES (?, ?, ?, ?,?,?,?,?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, kodeTransaksi);
            p.setString(2, tanggal);
            p.setString(3, idpelanggan);
            p.setString(4, namapelanggan);
            p.setString(5, admin);
            p.setString(6, total);
            p.setString(7, kembalian);
            p.setString(8, bayar);
           
            
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("simpan penjualan error");
        }

        try {
            Connection c = Koneksi.getConnection();
            int baris = jTable1.getRowCount();

            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO detail_transaksi(kode_transaksi, kode_barang, nama_barang, jumlah, harga, Total) VALUES('"
              + jTable1.getValueAt(i, 0) +"','"+ jTable1.getValueAt(i, 1) +"','"+ jTable1.getValueAt(i, 2)
                +"','"+ jTable1.getValueAt(i, 3) +"','"+ jTable1.getValueAt(i, 4) +"','"+ jTable1.getValueAt(i, 5)
                +"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("simpan penjualanrinci error");
        }
        clear();
        utama();
        autonumber();
        autonumber1();
        kosong();
        txTampil.setText("Rp. 0");
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      this.setVisible(false);
       new MENU().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

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

    private void txTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTampilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTampilActionPerformed

    private void txNAMAPELANGGANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNAMAPELANGGANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNAMAPELANGGANActionPerformed

    private void txBAYARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBAYARActionPerformed
      int total, bayar, kembalian;

        total = Integer.valueOf(txtTOTALBAYAR.getText());
        bayar = Integer.valueOf(txBAYAR.getText());

        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txKEMBALIAN.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txBAYARActionPerformed

    private void CaribarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaribarangActionPerformed
          ListBarang a = new ListBarang();
        a.setVisible(true);
    }//GEN-LAST:event_CaribarangActionPerformed

    private void txIDPELANGGAN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIDPELANGGAN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIDPELANGGAN2ActionPerformed

    private void admin_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_txtMouseClicked
      admin_txt.setText(Loginbaru.txt_user.getText());
    }//GEN-LAST:event_admin_txtMouseClicked

    private void txKEMBALIANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKEMBALIANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKEMBALIANActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CETAK;
    private javax.swing.JButton BTN_HAPUS;
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JButton BTN_TAMBAH;
    private javax.swing.JButton Caribarang;
    private static javax.swing.JTextField admin_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel maximize;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField txBAYAR;
    public static javax.swing.JTextField txHARGA;
    private javax.swing.JTextField txIDPELANGGAN2;
    private javax.swing.JTextField txJUMLAH;
    private javax.swing.JTextField txKEMBALIAN;
    public static javax.swing.JTextField txKODEBARANG;
    private javax.swing.JTextField txKODETRANSAKSI;
    public static javax.swing.JTextField txNAMABARANG;
    private javax.swing.JTextField txNAMAPELANGGAN;
    private javax.swing.JTextField txTGLTRANSAKSI;
    private javax.swing.JTextField txTampil;
    private javax.swing.JTextField txtCetak;
    private javax.swing.JTextField txtTOTALBAYAR;
    // End of variables declaration//GEN-END:variables
}
