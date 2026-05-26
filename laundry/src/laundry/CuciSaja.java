/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author LENOVO
 */
public class CuciSaja extends Layanan {
 
    // ── Constructor ────────────────────────────────────────────────
    public CuciSaja() {
        //Inheritance:
        // Memanggil constructor parent (Layanan)
        // id=1, nama, dan harga sesuai data di tabel layanan
        super(1, "Cuci Saja", 5000);
    }
 
    // ── Override hitungBiaya (Polymorphism) ────────────────────────
    // Cuci saja: harga per kg × berat, minimum 1 kg
    @Override
    public double hitungBiaya(double beratKg) {
        double berat = Math.max(beratKg, 1.0); // minimal 1 kg
        return berat * getHargaPerKg();
    }
}
 
