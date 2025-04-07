# 🐾 Pet Adoption System

Sistem adopsi hewan peliharaan berbasis Java dengan antarmuka berbasis menu (console). Sistem ini memisahkan peran antara **Admin** dan **User** untuk memudahkan pengelolaan hewan dan proses adopsi.

---

## 📌 Fitur Utama

### Untuk Admin:
- Tambah data hewan yang tersedia untuk diadopsi.
- Lihat daftar semua hewan.
- Lihat permintaan adopsi dari user.
- Setujui permintaan adopsi.

### Untuk User:
- Lihat daftar hewan yang tersedia.
- Ajukan permintaan adopsi.

---

## 🛠️ Teknologi yang Digunakan

- Java (OOP)
- Antarmuka console (CLI)
- Interface dan implementasi terpisah (modular design)

---

## 📚 Struktur Kelas dan Interface

### Interface
- `PetService` – Untuk manajemen hewan.
- `UserService` – Untuk manajemen user.
- `AdoptionService` – Untuk mengelola permintaan adopsi.

### Kelas Implementasi
- `PetServiceImpl`
- `UserServiceImpl`
- `AdoptionServiceImpl`

### Kelas Entitas
- `User`
- `Pet`
- `AdoptionRequest`

### Handler
- `MenuHandler` – Mengelola logika menu untuk admin & user.

---

## ✅ Use Case & Role

### Admin
- Tambah Hewan
- Lihat Daftar Hewan
- Lihat Permintaan Adopsi
- Setujui Permintaan

### User
- Lihat Hewan Tersedia
- Ajukan Permintaan Adopsi

---

## ⚙️ Cara Menjalankan

1. Pastikan Java sudah terpasang di komputer.
2. Clone repository ini atau download source code-nya.
3. Compile semua file `.java`.
4. Jalankan `Main` class.

```bash
javac *.java
java Main


## Anggota Tim:
- Nisa Rianti (2208107010018)
- Akshania Maisa Rahmah (2208107010017)
