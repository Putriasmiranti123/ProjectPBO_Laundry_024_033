/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
 
import database.DBConnection;
import dto.RekapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class RekapController {
 
    private final Connection conn;
 
    public RekapController() {
        this.conn = DBConnection.getConnection();
    }
 
    // Ambil semua pesanan berdasarkan tanggal tertentu
    public List<RekapDTO> getRekapByTanggal(String tanggal) {
        List<RekapDTO> list = new ArrayList<>();
        String sql = "SELECT p.nama_pelanggan, l.nama_layanan, p.berat_kg, "
                   + "p.total_biaya, p.status, p.tanggal_masuk "
                   + "FROM pesanan p "
                   + "JOIN layanan l ON p.id_layanan = l.id_layanan "
                   + "WHERE DATE(p.tanggal_masuk) = ? "
                   + "ORDER BY p.tanggal_masuk ASC";
 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tanggal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RekapDTO(
                    rs.getString("nama_pelanggan"),
                    rs.getString("nama_layanan"),
                    rs.getDouble("berat_kg"),
                    rs.getDouble("total_biaya"),
                    rs.getString("status"),
                    rs.getString("tanggal_masuk")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    // Hitung total pendapatan dari list rekap
    public double getTotalPendapatan(List<RekapDTO> list) {
        return list.stream().mapToDouble(RekapDTO::getTotalBiaya).sum();
    }
 
    // Hitung total berat dari list rekap
    public double getTotalBerat(List<RekapDTO> list) {
        return list.stream().mapToDouble(RekapDTO::getBeratKg).sum();
    }
}