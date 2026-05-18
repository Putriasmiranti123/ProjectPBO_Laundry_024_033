/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author ASUS
 */
public abstract class Layanan {
 
    // ── Encapsulation: atribut dibuat private ──────────────────────
    private int    idLayanan;
    private String namaLayanan;
    private double hargaPerKg;
 
    // ── Constructor ────────────────────────────────────────────────
    public Layanan(int idLayanan, String namaLayanan, double hargaPerKg) {
        this.idLayanan   = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerKg  = hargaPerKg;
    }
 
    // ── Abstract method (Abstraction) ──────────────────────────────
    // Setiap subclass WAJIB mengimplementasikan cara hitung biayanya sendiri
    public abstract double hitungBiaya(double beratKg);
 
    // ── Getters & Setters (Encapsulation) ─────────────────────────
    public int getIdLayanan() {
        return idLayanan;
    }
 
    public void setIdLayanan(int idLayanan) {
        this.idLayanan = idLayanan;
    }
 
    public String getNamaLayanan() {
        return namaLayanan;
    }
 
    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }
 
    public double getHargaPerKg() {
        return hargaPerKg;
    }
 
    public void setHargaPerKg(double hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }
 
    // ── toString untuk debugging ───────────────────────────────────
    @Override
    public String toString() {
        return namaLayanan + " (Rp " + hargaPerKg + "/kg)";
    }
}