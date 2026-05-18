-- ============================================================
--  Sistem Manajemen Laundry
--  Database Setup Script
--  Jalankan script ini di MySQL Workbench atau phpMyAdmin
-- ============================================================

-- 1. Buat database
CREATE DATABASE IF NOT EXISTS db_laundry
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE db_laundry;

-- ============================================================
-- 2. Tabel LAYANAN
--    Menyimpan jenis-jenis layanan laundry beserta harganya
-- ============================================================
CREATE TABLE IF NOT EXISTS layanan (
    id_layanan   INT          AUTO_INCREMENT PRIMARY KEY,
    nama_layanan VARCHAR(100) NOT NULL,
    harga_per_kg DOUBLE       NOT NULL
);

-- ============================================================
-- 3. Tabel PESANAN
--    Menyimpan setiap transaksi pesanan dari pelanggan
-- ============================================================
CREATE TABLE IF NOT EXISTS pesanan (
    id_pesanan     INT          AUTO_INCREMENT PRIMARY KEY,
    nama_pelanggan VARCHAR(150) NOT NULL,
    id_layanan     INT          NOT NULL,
    berat_kg       DOUBLE       NOT NULL,
    total_biaya    DOUBLE       NOT NULL,
    status         VARCHAR(20)  NOT NULL DEFAULT 'Proses',
    tanggal_masuk  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,

    -- Foreign Key ke tabel layanan
    CONSTRAINT fk_pesanan_layanan
        FOREIGN KEY (id_layanan) REFERENCES layanan(id_layanan)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- ============================================================
-- 4. Data awal (seed) untuk tabel layanan
--    Sesuai dengan class CuciSaja & CuciSetrika di Java
-- ============================================================
INSERT INTO layanan (nama_layanan, harga_per_kg) VALUES
    ('Cuci Saja',         5000),
    ('Cuci + Setrika',    8000);

-- ============================================================
-- 5. Contoh data pesanan (opsional, untuk testing)
-- ============================================================
INSERT INTO pesanan (nama_pelanggan, id_layanan, berat_kg, total_biaya, status) VALUES
    ('Budi Santoso',   1, 3.0,  15000, 'Selesai'),
    ('Ani Rahayu',     2, 2.5,  20000, 'Proses'),
    ('Dimas Pratama',  1, 5.0,  25000, 'Proses'),
    ('Siti Aminah',    2, 1.5,  12000, 'Selesai');

-- ============================================================
-- 6. Verifikasi — jalankan ini untuk memastikan berhasil
-- ============================================================
SELECT * FROM layanan;
SELECT
    p.id_pesanan,
    p.nama_pelanggan,
    l.nama_layanan,
    p.berat_kg,
    p.total_biaya,
    p.status,
    p.tanggal_masuk
FROM pesanan p
JOIN layanan l ON p.id_layanan = l.id_layanan
ORDER BY p.tanggal_masuk DESC;
