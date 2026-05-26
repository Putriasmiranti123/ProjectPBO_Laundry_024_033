/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.RekapController;
import dto.RekapDTO;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author ASUS
 */
public class RekapView extends javax.swing.JFrame {
 
    private RekapController controller;
    private JSpinner dateSpinner;
    private JTable tabelRekap;
    private JScrollPane scrollPane;
    private JButton btnRefresh;
    private JLabel lblTotalPesanan, lblTotalBerat, lblTotalPendapatan;
    private JPanel panelSummary, panelForm, panelTable;
    private JLabel lblTitle, lblSub;
 
    public RekapView() {
        controller = new RekapController();
        initComponents();
        applyStyles();
        loadRekap(); // load hari ini otomatis
    }
 
    private void initComponents() {
        setTitle("Rekap Pendapatan Harian - Laundry In Ajah");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(700, 520);
        setLocationRelativeTo(null);
        setResizable(false);
 
        // ── Header ──
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 12));
        panelHeader.setPreferredSize(new java.awt.Dimension(700, 65));
 
        lblTitle = new JLabel("REKAP PENDAPATAN HARIAN");
        lblTitle.setFont(new java.awt.Font("Bahnschrift", 1, 18));
        lblTitle.setForeground(new java.awt.Color(24, 95, 165));
 
        lblSub = new JLabel("Laundry In Ajah");
        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSub.setForeground(new java.awt.Color(55, 138, 221));
 
        JPanel headerText = new JPanel();
        headerText.setLayout(new java.awt.GridLayout(2, 1));
        headerText.setOpaque(false);
        headerText.add(lblTitle);
        headerText.add(lblSub);
        panelHeader.add(headerText);
 
        // ── Form pilih tanggal ──
        panelForm = new JPanel();
        panelForm.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 16, 10));
        panelForm.setPreferredSize(new java.awt.Dimension(700, 50));
 
        JLabel lblTanggal = new JLabel("Pilih Tanggal:");
        lblTanggal.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblTanggal.setForeground(new java.awt.Color(80, 80, 80));
 
        // Date spinner pakai SpinnerDateModel
        java.util.Date today = new java.util.Date();
        dateSpinner = new JSpinner(new SpinnerDateModel(today, null, today, java.util.Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setPreferredSize(new java.awt.Dimension(120, 30));
        dateSpinner.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        btnRefresh = new JButton("Tampilkan");
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnRefresh.setBackground(new java.awt.Color(24, 95, 165));
        btnRefresh.setForeground(java.awt.Color.WHITE);
        btnRefresh.setOpaque(true);
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 30));
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(e -> loadRekap());
 
        panelForm.add(lblTanggal);
        panelForm.add(dateSpinner);
        panelForm.add(btnRefresh);
 
        // ── Summary cards ──
        panelSummary = new JPanel();
        panelSummary.setLayout(new java.awt.GridLayout(1, 3, 12, 0));
        panelSummary.setPreferredSize(new java.awt.Dimension(660, 70));
 
        lblTotalPesanan    = new JLabel("0", SwingConstants.CENTER);
        lblTotalBerat      = new JLabel("0 kg", SwingConstants.CENTER);
        lblTotalPendapatan = new JLabel("Rp 0", SwingConstants.CENTER);
 
        panelSummary.add(buatCard("Total Pesanan", lblTotalPesanan));
        panelSummary.add(buatCard("Total Berat", lblTotalBerat));
        panelSummary.add(buatCard("Total Pendapatan", lblTotalPendapatan));
 
        // ── Tabel ──
        tabelRekap = new JTable();
        tabelRekap.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nama Pelanggan", "Jenis Layanan", "Berat (Kg)", "Total Biaya", "Status"}
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        scrollPane = new JScrollPane(tabelRekap);
        scrollPane.setPreferredSize(new java.awt.Dimension(660, 220));
 
        // ── Main layout ──
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.BorderLayout());
 
        JPanel topSection = new JPanel();
        topSection.setLayout(new javax.swing.BoxLayout(topSection, javax.swing.BoxLayout.Y_AXIS));
        topSection.add(panelHeader);
        topSection.add(panelForm);
 
        JPanel centerSection = new JPanel();
        centerSection.setLayout(new java.awt.BorderLayout(0, 10));
        centerSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 16, 20));
        centerSection.add(panelSummary, java.awt.BorderLayout.NORTH);
        centerSection.add(scrollPane, java.awt.BorderLayout.CENTER);
 
        mainPanel.add(topSection, java.awt.BorderLayout.NORTH);
        mainPanel.add(centerSection, java.awt.BorderLayout.CENTER);
 
        setContentPane(mainPanel);
    }
 
    private JPanel buatCard(String judul, JLabel lblNilai) {
        JPanel card = new JPanel();
        card.setLayout(new java.awt.GridLayout(2, 1));
        card.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(181, 212, 244), 1),
            javax.swing.BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));
        card.setBackground(new java.awt.Color(240, 248, 255));
 
        JLabel lblJudul = new JLabel(judul, SwingConstants.CENTER);
        lblJudul.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblJudul.setForeground(new java.awt.Color(80, 80, 80));
 
        lblNilai.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblNilai.setForeground(new java.awt.Color(24, 95, 165));
 
        card.add(lblJudul);
        card.add(lblNilai);
        return card;
    }
 
    private void applyStyles() {
        getContentPane().setBackground(new java.awt.Color(235, 245, 255));
        panelForm.setBackground(new java.awt.Color(235, 245, 255));
        panelSummary.setBackground(new java.awt.Color(235, 245, 255));
 
        // Styling tabel
        tabelRekap.getTableHeader().setBackground(new java.awt.Color(214, 234, 248));
        tabelRekap.getTableHeader().setForeground(new java.awt.Color(24, 95, 165));
        tabelRekap.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 12));
        tabelRekap.setRowHeight(28);
        tabelRekap.setSelectionBackground(new java.awt.Color(181, 212, 244));
        tabelRekap.setSelectionForeground(new java.awt.Color(24, 95, 165));
        tabelRekap.setGridColor(new java.awt.Color(220, 235, 248));
        tabelRekap.setBackground(java.awt.Color.WHITE);
        tabelRekap.setFont(new java.awt.Font("Segoe UI", 0, 12));
 
        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(
            new java.awt.Color(181, 212, 244), 1));
    }
 
    private void loadRekap() {
        // Ambil tanggal dari spinner
        java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String tanggal = sdf.format(selectedDate);
 
        List<RekapDTO> list = controller.getRekapByTanggal(tanggal);
 
        // Update tabel
        DefaultTableModel model = (DefaultTableModel) tabelRekap.getModel();
        model.setRowCount(0);
 
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
 
        for (RekapDTO r : list) {
            model.addRow(new Object[]{
                r.getNamaPelanggan(),
                r.getNamaLayanan(),
                r.getBeratKg() + " kg",
                nf.format(r.getTotalBiaya()),
                r.getStatus()
            });
        }
 
        // Update summary
        double totalPendapatan = controller.getTotalPendapatan(list);
        double totalBerat = controller.getTotalBerat(list);
 
        lblTotalPesanan.setText(String.valueOf(list.size()));
        lblTotalBerat.setText(totalBerat + " kg");
        lblTotalPendapatan.setText(nf.format(totalPendapatan));
 
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada pesanan pada tanggal " + tanggal,
                "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
 
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new RekapView().setVisible(true));
    }
}
