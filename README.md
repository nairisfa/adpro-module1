# Aplikasi E-Shop

## Module 1
### Prinsip Clean Code

- **Separation of Concerns:** Kode terbagi dengan jelas ke dalam lapisan Controller, Service, dan Repository.
- **Penamaan:** Nama kelas dan metode mudah dipahami; struktur kode memudahkan perawatan dan pengembangan.
- **Komentar:** Komentar singkat disediakan untuk menjelaskan fungsi bagian-bagian penting.

### Praktik Keamanan

- **Proteksi CSRF:** Operasi yang mengubah data menggunakan metode POST untuk mengurangi risiko CSRF.
- **UUID untuk ID Produk:** Menghasilkan ID unik untuk setiap produk menggunakan UUID.
- **Validasi Input:** Validasi HTML dasar diterapkan; dapat ditingkatkan dengan validasi sisi server (misalnya
  menggunakan `@Valid`).

## Module 2
### Question 1

During the exercise, I found that my GitHub Actions workflow was using default token permissions, which were too
vulnerable
for the security checks and code scanning (Scorecard) to pass. To address this, I explicitly added:
```yaml
permission:
  contents: read
```
in my CI workflow (`.github/workflows/ci.yml`). By doing so, I followed the principle of least privilege, ensuring the
workflow only has the minimal access **(read)** it needs and thus resolving the flagged code quality/security issue.

### Question 2
Yes, I believe my current CI/CD setup fulfills the definitions of Continuous Integration and Continuous Deployment.
First, every push or pull request triggers automated tests and code scans, which catches integration issues early and
keeps my codebase stable. Second, once the tests pass, my pipeline automatically deploys the updated application to
Koyeb without manual intervention, exemplifying true Continuous Deployment. Finally, this end-to-end automation—from
code commit, to testing, to production deployment—ensures that my application is consistently maintained, tested, and
delivered in a reliable manner. 


