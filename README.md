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
  
![WhatsApp Image 2025-04-09 at 14 39 34_a8656be8](https://github.com/user-attachments/assets/d8d9e149-16c2-4964-be5f-257e55a12a70)

### Component Diagram
![WhatsApp Image 2025-04-09 at 16 14 34_32e67a86](https://github.com/user-attachments/assets/e24a6264-3733-430e-90bf-3282c4996b0e)

### Class Diagram
![tes drawio 1](https://github.com/user-attachments/assets/7cf20ade-00e3-45b2-9eef-993919a3178f)

---

## ⚙️ Cara Menjalankan

1. Pastikan Java sudah terpasang di komputer.
2. Clone repository ini atau download source code-nya.
3. Compile semua file `.java`.
4. Jalankan `Main` class.

```bash
javac *.java
java Main

## 👥 Anggota Tim:
- Nisa Rianti (2208107010018)
- Akshania Maisa Rahmah (2208107010017)
