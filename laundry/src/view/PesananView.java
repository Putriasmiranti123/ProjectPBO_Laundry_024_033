/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.PesananController;
import dto.PesananDTO;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * @author LENOVO
 */
public class PesananView extends javax.swing.JFrame {
 
    private int idPesananDipilih = -1;
 
    public PesananView() {
        initComponents();
        initComboBox();
        initMenuBar();
        applyStyles();
        loadTabel();
        initTabelListener();
    }
 
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new java.awt.Color(214, 234, 248));
 
        JMenu menuLaporan = new JMenu("Laporan");
        menuLaporan.setFont(new java.awt.Font("Segoe UI", 0, 12));
        menuLaporan.setForeground(new java.awt.Color(24, 95, 165));
 
        JMenuItem menuRekap = new JMenuItem("Rekap Pendapatan Harian");
        menuRekap.setFont(new java.awt.Font("Segoe UI", 0, 12));
        menuRekap.addActionListener(e -> bukaRekap());
 
        menuLaporan.add(menuRekap);
        menuBar.add(menuLaporan);
        setJMenuBar(menuBar);
    }
 
    private void bukaRekap() {
        RekapView rekap = new RekapView();
        rekap.setVisible(true);
    }
 
    private void initComboBox() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Cuci Saja");
        jComboBox1.addItem("Cuci + Setrika");
 
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Proses");
        jComboBox2.addItem("Selesai");
    }
 
    private void applyStyles() {
        // Window background
        getContentPane().setBackground(new java.awt.Color(235, 245, 255));
        
javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/image/mesincuci.jpeg"));
java.awt.Image img = icon.getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
jLabel5.setIcon(new javax.swing.ImageIcon(img));
jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        // Header panel
        jPanel1.setBackground(new java.awt.Color(214, 234, 248));
        jPanel1.setOpaque(true);
 
        // Judul
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 22));
        jLabel3.setForeground(new java.awt.Color(24, 95, 165));
 
        // Subtitle
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jLabel4.setForeground(new java.awt.Color(55, 138, 221));
 
        // Label form
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jLabel1.setForeground(new java.awt.Color(80, 80, 80));
        cbLayanan.setFont(new java.awt.Font("Segoe UI", 0, 12));
        cbLayanan.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        txtStatus.setFont(new java.awt.Font("Segoe UI", 0, 12));
        txtStatus.setForeground(new java.awt.Color(80, 80, 80));
        txtStatus.setBackground(new java.awt.Color(235, 245, 255));
        txtStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 4));
 
        // Input fields
        javax.swing.border.Border inputBorder = javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(181, 212, 244), 1),
            javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8)
        );
        txtNama.setBackground(new java.awt.Color(240, 248, 255));
        txtNama.setBorder(inputBorder);
        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        txtBerat.setBackground(new java.awt.Color(240, 248, 255));
        txtBerat.setBorder(inputBorder);
        txtBerat.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        // ComboBox
        jComboBox1.setBackground(new java.awt.Color(240, 248, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jComboBox2.setBackground(new java.awt.Color(240, 248, 255));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        btnRekap.setBackground(new java.awt.Color(24, 95, 165));
        btnRekap.setFont(new java.awt.Font("Segoe UI", 1, 11));
        btnRekap.setForeground(java.awt.Color.WHITE);
        btnRekap.setOpaque(true);
 
        // Tombol
        btnHapus.setBackground(new java.awt.Color(226, 75, 74));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnHapus.setForeground(java.awt.Color.WHITE);
        btnHapus.setPreferredSize(new java.awt.Dimension(80, 36));
        btnHapus.setMinimumSize(new java.awt.Dimension(80, 36));
        btnHapus.setMaximumSize(new java.awt.Dimension(80, 36));
        btnHapus.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 4, 12));
 
        btnSimpan.setBackground(new java.awt.Color(59, 109, 17));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSimpan.setForeground(java.awt.Color.WHITE);
        btnSimpan.setPreferredSize(new java.awt.Dimension(80, 36));
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 4, 12));
 
        btnEdit.setBackground(new java.awt.Color(24, 95, 165));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEdit.setForeground(java.awt.Color.WHITE);
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 36));
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 4, 12));
 
        // Tabel
        jTable4.getTableHeader().setBackground(new java.awt.Color(214, 234, 248));
        jTable4.getTableHeader().setForeground(new java.awt.Color(24, 95, 165));
        jTable4.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 12));
        jTable4.setRowHeight(28);
        jTable4.setSelectionBackground(new java.awt.Color(181, 212, 244));
        jTable4.setSelectionForeground(new java.awt.Color(24, 95, 165));
        jTable4.setGridColor(new java.awt.Color(220, 235, 248));
        jTable4.setBackground(java.awt.Color.WHITE);
        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        // Section title tabel
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabel6.setForeground(new java.awt.Color(24, 95, 165));
 
        // ScrollPane border
        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(
            new java.awt.Color(181, 212, 244), 1));
    }
 
    private void loadTabel() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
 
        try {
            PesananController controller = new PesananController();
            List<PesananDTO> listPesanan = controller.getAllPesanan();
 
            for (PesananDTO p : listPesanan) {
                model.addRow(new Object[]{
                    p.getIdPesanan(),
                    p.getNamaPelanggan(),
                    p.getNamaLayanan(),
                    p.getBeratKg(),
                    p.getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat data: " + e.getMessage());
        }
    }
 
    private void initTabelListener() {
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable4.getSelectedRow();
                if (row != -1) {
                    idPesananDipilih = Integer.parseInt(
                            jTable4.getValueAt(row, 0).toString());
                    txtNama.setText(jTable4.getValueAt(row, 1).toString());
                    jComboBox1.setSelectedItem(jTable4.getValueAt(row, 2).toString());
                    txtBerat.setText(jTable4.getValueAt(row, 3).toString());
                    jComboBox2.setSelectedItem(jTable4.getValueAt(row, 4).toString());
                }
            }
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
 
        jLabel1 = new javax.swing.JLabel();
        cbLayanan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRekap = new javax.swing.JButton();
        btnRekap.setText("Rekap Harian");
        btnRekap.addActionListener(evt -> bukaRekap());
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        txtNama = new javax.swing.JTextField();
        txtBerat = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtStatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 12));
        jLabel1.setText("Nama Pelanggan :");
 
        cbLayanan.setFont(new java.awt.Font("Bahnschrift", 0, 12));
        cbLayanan.setText("Jenis Layanan :");
 
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 12));
        jLabel2.setText("Berat (Kg) :");
 
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
 
        btnSimpan.setText("Simpan");
        btnSimpan.setOpaque(true);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
 
        btnEdit.setText("Edit");
        btnEdit.setOpaque(true);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
 
        btnHapus.setText("Hapus");
        btnHapus.setOpaque(true);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
 
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pesan", "Nama Pelanggan", "Jenis Layanan", "Berat (Kg)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
 
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
 
        jPanel1.setPreferredSize(new java.awt.Dimension(24, 24));
 
        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        jLabel3.setForeground(new java.awt.Color(93, 139, 202));
        jLabel3.setText("LAUNDRY IN AJAH");
 
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Pakaian Bersih, Hati Jadi Happy!!!");
 
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
 
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
 
        txtStatus.setFont(new java.awt.Font("Bahnschrift", 0, 12));
        txtStatus.setText("Status :");
        txtStatus.setOpaque(true);
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
 
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mesincuci.jpeg")));
 
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Daftar Pesanan Laundry ");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnSimpan)
                                .addGap(37, 37, 37)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btnRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>
 
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nama = txtNama.getText().trim();
            String beratStr = txtBerat.getText().trim().replace(',', '.');
            String status = jComboBox2.getSelectedItem().toString();
 
            if (nama.isEmpty() || beratStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Berat tidak boleh kosong!");
                return;
            }
 
            double berat = Double.parseDouble(beratStr);
            int idLayanan = jComboBox1.getSelectedIndex() + 1;
 
            PesananController controller = new PesananController();
            boolean sukses = controller.tambahPesanan(nama, idLayanan, berat, status);
 
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                txtNama.setText("");
                txtBerat.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                loadTabel();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Berat harus berupa angka (contoh: 2.5)");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
 
    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {
    }
 
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (idPesananDipilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu!");
            return;
        }
 
        try {
            String nama = txtNama.getText().trim();
            double berat = Double.parseDouble(txtBerat.getText().trim().replace(',', '.'));
            int idLayanan = jComboBox1.getSelectedIndex() + 1;
            String status = jComboBox2.getSelectedItem().toString(); //  pakai status dari combobox
 
            PesananController controller = new PesananController();
            boolean sukses = controller.updatePesanan(idPesananDipilih, nama, idLayanan, berat, status);
 
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                txtNama.setText("");
                txtBerat.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                idPesananDipilih = -1;
                loadTabel();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Berat harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        if (idPesananDipilih == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        int konfirmasi = JOptionPane.showConfirmDialog(
            this, "Yakin ingin menghapus data ini?", "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );
 
        if (konfirmasi == JOptionPane.YES_OPTION) {
            PesananController controller = new PesananController();
            boolean sukses = controller.deletePesanan(idPesananDipilih);
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                txtNama.setText("");
                txtBerat.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                idPesananDipilih = -1;
                loadTabel();
            }
        }
    }
 
    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {
    }
 
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    }
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PesananView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesananView().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnRekap;
    private javax.swing.JLabel cbLayanan;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration
}
 