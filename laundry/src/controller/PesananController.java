package controller;

import database.DBConnection;
import dto.PesananDTO;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import laundry.CuciSaja;
import laundry.CuciSetrika;
import laundry.Layanan;
import laundry.Pesanan;

public class PesananController {

    private final Connection conn;

    public PesananController() {
        this.conn = DBConnection.getConnection();
    }

    // ════════════════════════════════════════════════════════════════
    // TAMBAH pesanan baru
    // ════════════════════════════════════════════════════════════════
    public boolean tambahPesanan(String namaPelanggan, int idLayanan, double beratKg, String status) {
    if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
        throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong.");
    }
    if (beratKg <= 0) {
        throw new IllegalArgumentException("Berat pakaian harus lebih dari 0 kg.");
    }

    Layanan layanan = buatLayanan(idLayanan);
    Pesanan pesanan = new Pesanan(namaPelanggan.trim(), layanan, beratKg);

    String sql = "INSERT INTO pesanan (nama_pelanggan, id_layanan, berat_kg, total_biaya, status) "
               + "VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, pesanan.getNamaPelanggan());
        ps.setInt   (2, idLayanan);
        ps.setDouble(3, pesanan.getBeratKg());
        ps.setDouble(4, pesanan.getTotalBiaya());
        ps.setString(5, status); // ← pakai status dari parameter
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // ════════════════════════════════════════════════════════════════
    // AMBIL semua pesanan
    // ════════════════════════════════════════════════════════════════
    public List<PesananDTO> getAllPesanan() {
        List<PesananDTO> list = new ArrayList<>();
        String sql = "SELECT p.id_pesanan, p.nama_pelanggan, l.id_layanan, l.nama_layanan, "
                   + "p.berat_kg, p.total_biaya, p.status, p.tanggal_masuk "
                   + "FROM pesanan p JOIN layanan l ON p.id_layanan = l.id_layanan "
                   + "ORDER BY p.id_pesanan DESC";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapDTO(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error getAllPesanan: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    // ════════════════════════════════════════════════════════════════
    // UPDATE pesanan
    // ════════════════════════════════════════════════════════════════
    public boolean updatePesanan(int idPesanan, String namaPelanggan, int idLayanan, double beratKg, String status) {
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong.");
        }
        if (beratKg <= 0) {
            throw new IllegalArgumentException("Berat pakaian harus lebih dari 0 kg.");
        }

        Layanan layanan = buatLayanan(idLayanan);
        double totalBiaya = layanan.hitungBiaya(beratKg);

        String sql = "UPDATE pesanan SET nama_pelanggan=?, id_layanan=?, berat_kg=?, "
                   + "total_biaya=?, status=? WHERE id_pesanan=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, namaPelanggan.trim());
            ps.setInt   (2, idLayanan);
            ps.setDouble(3, beratKg);
            ps.setDouble(4, totalBiaya);
            ps.setString(5, status);
            ps.setInt   (6, idPesanan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ════════════════════════════════════════════════════════════════
    // UPDATE status saja
    // ════════════════════════════════════════════════════════════════
    public boolean updateStatus(int idPesanan, String statusBaru) {
        String sql = "UPDATE pesanan SET status=? WHERE id_pesanan=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, statusBaru);
            ps.setInt   (2, idPesanan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ════════════════════════════════════════════════════════════════
    // DELETE pesanan
    // ════════════════════════════════════════════════════════════════
    public boolean deletePesanan(int idPesanan) {
        String sql = "DELETE FROM pesanan WHERE id_pesanan=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPesanan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ════════════════════════════════════════════════════════════════
    // HELPER — mapping ResultSet → PesananDTO
    // ════════════════════════════════════════════════════════════════
    private PesananDTO mapDTO(ResultSet rs) throws SQLException {
        double totalBiaya = rs.getDouble("total_biaya");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        return new PesananDTO(
            rs.getInt("id_pesanan"),
            rs.getString("nama_pelanggan"),
            rs.getInt("id_layanan"),
            rs.getString("nama_layanan"),
            rs.getDouble("berat_kg"),
            totalBiaya,
            nf.format(totalBiaya),
            rs.getString("status"),
            rs.getString("tanggal_masuk")
        );
    }

    // ════════════════════════════════════════════════════════════════
    // HELPER — buat objek Layanan (Polymorphism)
    // ════════════════════════════════════════════════════════════════
    private Layanan buatLayanan(int idLayanan) {
        switch (idLayanan) {
            case 1 -> { return new CuciSaja(); }
            case 2 -> { return new CuciSetrika(); }
            default -> throw new IllegalArgumentException("Jenis layanan tidak dikenal: " + idLayanan);
        }
    }
}