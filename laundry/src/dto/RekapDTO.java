/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ASUS
 */
public class RekapDTO {
    private String namaPelanggan;
    private String namaLayanan;
    private double beratKg;
    private double totalBiaya;
    private String status;
    private String tanggalMasuk;
 
    public RekapDTO(String namaPelanggan, String namaLayanan, double beratKg,
                    double totalBiaya, String status, String tanggalMasuk) {
        this.namaPelanggan = namaPelanggan;
        this.namaLayanan = namaLayanan;
        this.beratKg = beratKg;
        this.totalBiaya = totalBiaya;
        this.status = status;
        this.tanggalMasuk = tanggalMasuk;
    }
 
    public String getNamaPelanggan()  { return namaPelanggan; }
    public String getNamaLayanan()    { return namaLayanan; }
    public double getBeratKg()        { return beratKg; }
    public double getTotalBiaya()     { return totalBiaya; }
    public String getStatus()         { return status; }
    public String getTanggalMasuk()   { return tanggalMasuk; }
}
 
