/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author ASUS
 */
public class CuciSetrika extends Layanan {
 
    // ── Constructor ────────────────────────────────────────────────
    public CuciSetrika() {
        super(2, "Cuci + Setrika", 8000);
    }
 
    // ── Override hitungBiaya (Polymorphism) ────────────────────────
    // Cuci + setrika: tarif lebih tinggi, minimum 1 kg
    @Override
    public double hitungBiaya(double beratKg) {
        double berat = Math.max(beratKg, 1.0);
        return berat * getHargaPerKg();
    }
}
