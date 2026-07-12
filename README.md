# 📱 MobileTesting

**Automation Testing Framework untuk Aplikasi Mobile** menggunakan **Katalon Studio** dan **Appium**.

![Katalon Studio](https://img.shields.io/badge/Katalon-Studio-FF6600?style=flat-square)
![Appium](https://img.shields.io/badge/Appium-Mobile%20Testing-9B0000?style=flat-square)
![Groovy](https://img.shields.io/badge/Groovy-92.2%25-4298B8?style=flat-square)
![TypeScript](https://img.shields.io/badge/TypeScript-7.8%25-3178C6?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)

---

## 📌 Tentang Proyek

Repository ini berisi framework automation testing untuk aplikasi mobile Android, dibangun di atas **Katalon Studio** dengan dukungan driver **Appium** untuk eksekusi test di device fisik maupun emulator.

Framework ini mencakup:

- ✅ Test case & test suite terstruktur
- ✅ Object Repository untuk manajemen UI element
- ✅ Data-driven testing dengan sumber data eksternal (Excel)
- ✅ Profile konfigurasi untuk multi-environment
- ✅ Custom script Groovy untuk logika testing tambahan

---

## 🛠️ Tech Stack

| Komponen | Teknologi |
|---|---|
| Automation Tool | Katalon Studio |
| Mobile Driver | Appium |
| Bahasa Script | Groovy, TypeScript |
| Build Tool | Gradle |
| Test Data | Excel (.xlsx) |
| Target Platform | Android (APK) |

---

## 📂 Struktur Proyek

```
MobileTesting/
├── Data Files/           # Sumber data eksternal untuk data-driven testing
├── Drivers/              # Driver Appium/mobile yang dibutuhkan
├── Include/
│   └── config/           # File konfigurasi tambahan
├── Object Repository/    # Repository UI element (locator objects)
├── Profiles/             # Konfigurasi environment (dev, staging, prod, dll)
├── Scripts/
│   └── Master/           # Script Groovy custom
├── Test Cases/
│   └── Master/           # Kumpulan test case
├── Test Suites/          # Kumpulan test suite (grouping test case)
├── apk/                  # File APK aplikasi yang akan ditest
├── settings/             # Pengaturan project Katalon
├── .gitignore
├── build.gradle          # Konfigurasi build Gradle
├── console.properties    # Konfigurasi eksekusi via console/CLI
├── testMobile.prj        # File utama project Katalon Studio
└── README.md
```

---

## ⚙️ Prasyarat

Sebelum menjalankan project ini, pastikan sudah terinstall:

1. **Katalon Studio** (versi terbaru direkomendasikan) — [download di sini](https://katalon.com/download)
2. **Java Development Kit (JDK)** 8 atau lebih tinggi
3. **Android SDK** & **Android Studio** (untuk emulator/device Android)
4. **Appium Server** — [dokumentasi instalasi](https://appium.io/docs/en/latest/quickstart/install/)
5. **Node.js** (dibutuhkan oleh Appium)
6. Device Android fisik (USB debugging aktif) **atau** emulator Android yang sudah dikonfigurasi

---

## 🚀 Cara Menjalankan

### 1. Clone Repository

```bash
git clone https://github.com/RamdaniBagus/MobileTesting.git
cd MobileTesting
```

### 2. Buka Project di Katalon Studio

- Jalankan **Katalon Studio**
- Pilih **File → Open Project**
- Arahkan ke folder hasil clone dan pilih file `testMobile.prj`

### 3. Konfigurasi Appium & Device

- Pastikan **Appium Server** sudah berjalan
- Hubungkan device Android via USB (aktifkan USB debugging) atau jalankan emulator
- Sesuaikan konfigurasi device pada Katalon Studio (**Project → Settings → Mobile**)

### 4. Jalankan Test

**Via Katalon Studio (GUI):**
- Buka folder **Test Suites**
- Klik kanan pada test suite yang ingin dijalankan → **Run**

**Via Command Line (Console Mode):**

```bash
katalonc -noSplash -runMode=console -projectPath="<path_ke_project>/testMobile.prj" -retry=0 -testSuitePath="Test Suites/<nama_test_suite>" -executionProfile="default"
```

> Ganti `<path_ke_project>` dan `<nama_test_suite>` sesuai kebutuhan.

---

## 🧪 Data-Driven Testing

Project ini menggunakan file Excel sebagai sumber data testing, terletak di root project dan folder `Data Files/`. Untuk menambah skenario data baru, cukup tambahkan baris pada file data source yang sudah terhubung ke test case terkait — tidak perlu mengubah script.

---

## 📁 Penjelasan Folder Penting

| Folder | Fungsi |
|---|---|
| `Test Cases/Master` | Berisi seluruh test case individual |
| `Test Suites` | Kumpulan test case yang dijalankan sebagai satu kesatuan |
| `Object Repository` | Menyimpan locator/UI element yang dipakai test case |
| `Profiles` | Variabel environment (URL, kredensial, dsb per environment) |
| `Scripts/Master` | Groovy script custom untuk logika testing kompleks |
| `Drivers` | Binary/driver pendukung eksekusi Appium |

---

## 🤝 Kontribusi

Kontribusi sangat terbuka! Untuk berkontribusi:

1. Fork repository ini
2. Buat branch baru (`git checkout -b fitur/nama-fitur`)
3. Commit perubahan (`git commit -m "Menambahkan fitur X"`)
4. Push ke branch (`git push origin fitur/nama-fitur`)
5. Buat Pull Request

---

## 👤 Author

**Ramdani Bagus**
GitHub: [@RamdaniBagus](https://github.com/RamdaniBagus)

---

## 📄 Lisensi

Belum ditentukan. Hubungi pemilik repository untuk informasi penggunaan lebih lanjut.
