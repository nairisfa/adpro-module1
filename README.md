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

## Module 3

Applying SOLID principles in software development provides several advantages, including:

### 1. *Improved Maintainability*

By following the SRP, classes have a single responsibility, making it easier to understand, modify, and extend the
codebase. For example, the ProductService class is responsible for product-related logic, while the ProductController
class handles HTTP requests and responses.

### 2. *Enhanced Flexibility*

By adhering to the OCP, classes are open for extension but closed for modification, allowing new features to be added
without altering existing code. For example, new models can be easily added by extending the ProductRepository interface
without altering other implementation.

Not applying *SOLID* principles in software development can lead to several disadvantages, including:

### 1. *Increased Complexity*

Ignoring the SRP can lead to classes with multiple responsibilities, making the code harder to understand and maintain.
For example, a class handling both business logic and data access can become overly complex and difficult to debug.

### 2. *Tight Coupling*

Disregarding the OCP can result in tightly coupled classes, making it challenging to add new features or modify existing
ones without affecting other parts of the code. For instance, changes to a base class might require updates in multiple
subclasses.


