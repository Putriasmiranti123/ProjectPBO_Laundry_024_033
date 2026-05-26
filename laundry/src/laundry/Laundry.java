/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package laundry;

import view.PesananView;

/**
 * Main Class untuk menjalankan aplikasi Laundry
 * 
 * @author LENOVO
 */
public class Laundry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Memanggil dan menampilkan form utama (PesananView)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek PesananView dan menampilkannya
                new PesananView().setVisible(true);
            }
        });
    }
}