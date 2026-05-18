# Laundry Management System

Sistem manajemen laundry berbasis Java yang dibuat untuk membantu proses pengelolaan data laundry seperti data pelanggan, transaksi, dan layanan laundry secara lebih terstruktur dan efisien. Project ini dikembangkan sebagai tugas Praktikum Pemrograman Berorientasi Objek (PBO).

## Features

* CRUD Data Pelanggan
* CRUD Data Laundry
* CRUD Jenis Layanan
* CRUD Transaksi
* Perhitungan total harga laundry
* Tampilan GUI menggunakan Java Swing
* Integrasi Database MySQL
* Penyimpanan data secara permanen

---

## Technologies Used

* Java
* Java Swing
* MySQL
* JDBC Connector
* NetBeans IDE

---

## Project Structure

```plaintext
ProjectPBO_Laundry_024_033
├── src/
│   ├── view/
│   ├── controller/
│   ├── model/
│   ├── database/
│   └── main/
├── database/
├── lib/
└── README.md
```

---

## Database Configuration

1. Buat database MySQL:

```sql
CREATE DATABASE laundry_db;
```

2. Import file database `.sql` yang tersedia pada folder database.

3. Atur koneksi database pada file konfigurasi:

```java
String url = "jdbc:mysql://localhost:3306/laundry_db";
String username = "root";
String password = "";
```

---

##  How to Run

1. Clone repository ini:

```bash
git clone https://github.com/Putriasmiranti123/ProjectPBO_Laundry_024_033.git
```

2. Buka project menggunakan NetBeans atau IDE Java lainnya.

3. Pastikan:

   * MySQL sudah aktif
   * JDBC Driver sudah ditambahkan ke library project

4. Jalankan file main.
---

## Architecture

Project ini menggunakan konsep **Object Oriented Programming (OOP)** dengan pembagian:
* Model → mengelola data
* View → tampilan GUI
* Controller → penghubung logic dan tampilan

Konsep ini membantu kode menjadi:
* lebih terstruktur
* mudah dikembangkan
* lebih mudah dipelihara
---

## Learning Objectives

Project ini dibuat untuk mempelajari:

* Pemrograman Berorientasi Objek (PBO)
* Implementasi GUI Java Swing
* Koneksi Java dengan Database MySQL
* Penerapan CRUD Application
* Struktur arsitektur aplikasi sederhana
