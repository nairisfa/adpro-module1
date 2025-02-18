# Aplikasi E-Shop


### Prinsip Clean Code
- **Separation of Concerns:** Kode terbagi dengan jelas ke dalam lapisan Controller, Service, dan Repository.
- **Penamaan:** Nama kelas dan metode mudah dipahami; struktur kode memudahkan perawatan dan pengembangan.
- **Komentar:** Komentar singkat disediakan untuk menjelaskan fungsi bagian-bagian penting.

### Praktik Keamanan
- **Proteksi CSRF:** Operasi yang mengubah data menggunakan metode POST untuk mengurangi risiko CSRF.
- **UUID untuk ID Produk:** Menghasilkan ID unik untuk setiap produk menggunakan UUID.
- **Validasi Input:** Validasi HTML dasar diterapkan; dapat ditingkatkan dengan validasi sisi server (misalnya menggunakan `@Valid`).
