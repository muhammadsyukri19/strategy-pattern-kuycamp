## Tugas Praktikum Analisis & Perancangan Sistem (Strategy Pattern)

## Nama: Muhammad Syukri

## NPM: 2308107010060

### Deskripsi Proyek: Strategy Pattern pada Sistem KuyCamp

##### Proyek ini mendemonstrasikan implementasi Strategy Design Pattern untuk mengatasi kebutuhan bisnis yang memiliki banyak algoritma berbeda, yaitu Penentuan Biaya Tambahan (Denda) pada sistem penyewaan alat camping KuyCamp.

##### Sistem secara dinamis memilih strategi perhitungan berdasarkan jenis masalah yang dihadapi (keterlambatan atau kerusakan).

### Komponen Utama:

##### - BiayaTambahanStrategy: Interface (Strategi)

##### - DendaKeterlambatanStrategy: Implementasi untuk denda harian (1.5x harga sewa).

##### - TanggunganKerusakanStrategy: Implementasi untuk tanggungan persentase dari harga alat.

##### - SewaAlatContext: Kelas Konteks yang menjalankan strategi yang dipilih.

### Cara Kompilasi dan Eksekusi

##### Pastikan telah menginstal Java Development Kit (JDK).

#### 1. Kompilasi (Membentuk Bytecode)

Gunakan perintah javac di Terminal/Command Prompt, arahkan ke folder tempat KuyCampStrategyDemo.java berada:

```bash
javac KuyCampStrategyDemo.java
```

#### Hasil: Akan terbentuk beberapa file .class di direktori yang sama.

#### 2. Eksekusi (Menjalankan Program)

Gunakan perintah java pada nama kelas utama:

```bash
java KuyCampStrategyDemo
```

#### 3. Skenario Interaktif

Program akan meminta Anda memilih salah satu skenario denda:

| Pilihan | Masukan yang Diperlukan        | Strategi yang Dipilih         |
| ------- | ------------------------------ | ----------------------------- |
| **1**   | Masukkan jumlah hari terlambat | `DendaKeterlambatanStrategy`  |
| **2**   | Masukkan persentase kerusakan  | `TanggunganKerusakanStrategy` |

#### Contoh Eksekusi:

```bash
--- PENENTUAN DENDA ALAT KUYCAMP (Strategy Pattern Demo) ---

Pilih Jenis Masalah:

1. Keterlambatan Pengembalian
2. Kerusakan Alat (Sobek/Patah)
   Pilihan (1/2): 2
   Masukkan estimasi persentase kerusakan (1-100%): 20
   Menerapkan metode perhitungan: TanggunganKerusakanStrategy -> [Strategi Kerusakan] Tanggungan: 20% dari Harga Alat Baru (500000.0)

=============================================
Total Biaya Tambahan Dikenakan: Rp 100.000,00
=============================================
```
