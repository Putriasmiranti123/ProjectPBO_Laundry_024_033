package laundry;

// PERBAIKAN: Gunakan java.sql.Timestamp agar cocok dengan database JDBC
import java.sql.Timestamp; 

/**
 * Class Model Pesanan
 * Merepresentasikan data transaksi laundry
 */
public class Pesanan {
 
    // ── Konstanta status ───────────────────────────────────────────
    public static final String STATUS_PROSES  = "Proses";
    public static final String STATUS_SELESAI = "Selesai";
 
    // ── Atribut ────────────────────────────────────────────────────
    private int       idPesanan;
    private String    namaPelanggan;
    private Layanan   layanan;       
    private double    beratKg;
    private double    totalBiaya;
    private String    status;
    private Timestamp tanggalMasuk;
 
    // ── Constructor penuh (untuk load dari database) ───────────────
    public Pesanan(int idPesanan, String namaPelanggan, Layanan layanan,
                   double beratKg, double totalBiaya, String status,
                   Timestamp tanggalMasuk) {
        this.idPesanan     = idPesanan;
        this.namaPelanggan = namaPelanggan;
        this.layanan       = layanan;
        this.beratKg       = beratKg;
        this.totalBiaya    = totalBiaya;
        this.status        = status;
        this.tanggalMasuk  = tanggalMasuk;
    }
 
    // ── Constructor untuk pesanan baru ─────────────────────────────
    public Pesanan(String namaPelanggan, Layanan layanan, double beratKg) {
        this.namaPelanggan = namaPelanggan;
        this.layanan       = layanan;
        this.beratKg       = beratKg;
        // Menghitung biaya otomatis saat objek dibuat
        this.totalBiaya    = layanan.hitungBiaya(beratKg); 
        this.status        = STATUS_PROSES;
    }
 
    // ── Getters & Setters ──────────────────────────────────────────
    public int getIdPesanan() { return idPesanan; }
    public void setIdPesanan(int idPesanan) { this.idPesanan = idPesanan; }
 
    public String getNamaPelanggan() { return namaPelanggan; }
    public void setNamaPelanggan(String namaPelanggan) { this.namaPelanggan = namaPelanggan; }
 
    public Layanan getLayanan() { return layanan; }
    public void setLayanan(Layanan layanan) {
        this.layanan    = layanan;
        this.totalBiaya = layanan.hitungBiaya(this.beratKg); 
    }
 
    public double getBeratKg() { return beratKg; }
    public void setBeratKg(double beratKg) {
        this.beratKg    = beratKg;
        this.totalBiaya = layanan.hitungBiaya(beratKg); 
    }
 
    public double getTotalBiaya() { return totalBiaya; }
    // totalBiaya tidak perlu setter manual karena sudah dihitung otomatis di atas

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
 
    public Timestamp getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(Timestamp tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
 
    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %.1f kg | Rp %.0f | %s",
            idPesanan, namaPelanggan, (layanan != null ? layanan.getNamaLayanan() : "-"),
            beratKg, totalBiaya, status);
    }
}