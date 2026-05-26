/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author LENOVO
 */
public class CuciSetrika extends Layanan {
 
    // ── Constructor ────────────────────────────────────────────────
    //Inheritance: Memanggil constructor parent class (Layanan)
    //menggunakan super()
    public CuciSetrika() {
        super(2, "Cuci + Setrika", 8000);
    }
 
    // ── Override hitungBiaya (Polymorphism) ────────────────────────
    // Cuci + setrika: tarif lebih tinggi, minimum 1 kg
    @Override
    public double hitungBiaya(double beratKg) {
        double berat = Math.max(beratKg, 1.0); //Menentukan minimal berat laundry 1 kg
        return berat * getHargaPerKg(); //Menghitung total biaya laundry
    }
}
