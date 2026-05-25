package laundry;

import view.PesananView;

/**
 * Main Class untuk menjalankan aplikasi Laundry
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