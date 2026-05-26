/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */

public class DBConnection {
    //Encapsulation: privat biar db tdk bisa di akses dari luar
    private static final String URL      = "jdbc:mysql://localhost:3306/db_laundry";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // kalau XAMPP default kosong

    //Menyimpan object koneksi database
    private static Connection connection = null;
    private DBConnection() {}

    // Static method digunakan agar koneksi dapat dipanggil tanpa membuat objek baru
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                
                // JDBC Driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Membuka koneksi ke database
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                System.out.println("✓ Koneksi database berhasil.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Menangani error jika driver database tidak ditemukan

        } catch (SQLException e) {
            e.printStackTrace(); // Menangani error SQL/database
        }

        return connection;
    }

    public static void closeConnection() { //menutup koneksi database
        try {

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}