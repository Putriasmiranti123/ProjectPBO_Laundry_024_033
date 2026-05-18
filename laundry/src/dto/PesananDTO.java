package dto;

/**
 * Data Transfer Object untuk Pesanan
 * Digunakan untuk menyalurkan data dari database ke tampilan (View)
 */
public class PesananDTO {
 
    private int    idPesanan;
    private String namaPelanggan;
    private int    idLayanan;
    private String namaLayanan;
    private double beratKg;
    private double totalBiaya;
    private String totalBiayaFormatted; 
    private String status;
    private String tanggalMasuk;
 
    public PesananDTO() {}
 
    public PesananDTO(int idPesanan, String namaPelanggan, int idLayanan,
                      String namaLayanan, double beratKg, double totalBiaya,
                      String totalBiayaFormatted, String status, String tanggalMasuk) {
        this.idPesanan          = idPesanan;
        this.namaPelanggan      = namaPelanggan;
        this.idLayanan          = idLayanan;
        this.namaLayanan        = namaLayanan;
        this.beratKg            = beratKg;
        this.totalBiaya         = totalBiaya;
        this.totalBiayaFormatted = totalBiayaFormatted;
        this.status             = status;
        this.tanggalMasuk       = tanggalMasuk;
    }
 
    // ── Getters & Setters ──────────────────────────────────────────
    
    // Perbaikan: Tambahkan metode ini agar sinkron dengan PesananView
    public int getIdPesan() { 
        return idPesanan; 
    }

    // Perbaikan: Tambahkan metode ini agar sinkron dengan PesananView
    public double getBerat() { 
        return beratKg; 
    }

    public int getIdPesanan()           { return idPesanan; }
    public void setIdPesanan(int v)      { this.idPesanan = v; }
 
    public String getNamaPelanggan()              { return namaPelanggan; }
    public void setNamaPelanggan(String v)       { this.namaPelanggan = v; }
 
    public int getIdLayanan()           { return idLayanan; }
    public void setIdLayanan(int v)      { this.idLayanan = v; }
 
    public String getNamaLayanan()                { return namaLayanan; }
    public void setNamaLayanan(String v)         { this.namaLayanan = v; }
 
    public double getBeratKg()             { return beratKg; }
    public void setBeratKg(double v)     { this.beratKg = v; }
 
    public double getTotalBiaya()          { return totalBiaya; }
    public void setTotalBiaya(double v)  { this.totalBiaya = v; }
 
    public String getTotalBiayaFormatted()        { return totalBiayaFormatted; }
    public void setTotalBiayaFormatted(String v){ this.totalBiayaFormatted = v; }
 
    public String getStatus()                     { return status; }
    public void setStatus(String v)              { this.status = v; }
 
    public String getTanggalMasuk()                { return tanggalMasuk; }
    public void setTanggalMasuk(String v)         { this.tanggalMasuk = v; }
 
    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %.1f kg | %s | %s",
            idPesanan, namaPelanggan, namaLayanan,
            beratKg, totalBiayaFormatted, status);
    }
}