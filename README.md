# TP6DPBO2526C1
Janji : Saya Aracelli Jasmine Malaika dengan NIM 2501804 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya, maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# Deskripsi Program
Program Flappy Bird merupakan game sederhana berbasis Java yang dikembangkan menggunakan Java Swing. Pada tugas praktikum ini, program dilengkapi dengan fitur Game Over, restart permainan, sistem skor, Main Menu, serta audio.

Game memiliki tampilan bertema pastel dengan latar belakang biru muda, burung berwarna kuning, awan, dan pipa berwarna hijau. Pemain harus menghindari pipa agar dapat memperoleh skor sebanyak mungkin.

## 1. Desain Program
Program dibuat menggunakan bahasa pemrograman Java dengan antarmuka grafis Java Swing. Program dibagi menjadi beberapa class dengan fungsi yang berbeda.

### Class pada Program
- **`App.java`**: Menjalankan program.
- **`Menu.java`**: Menampilkan Main Menu dengan tombol Start dan Exit.
- **`View.java`**: Mengatur tampilan permainan, burung, pipa, skor, dan Game Over.
- **`Player.java`**: Mengatur objek burung dan pergerakannya.
- **`Pipe.java`**: Mengatur objek pipa sebagai rintangan.
- **`Logic.java`**: Mengatur logika permainan, pergerakan objek, tabrakan, dan penambahan skor.
- **`Sound.java`**: Mengatur pemutaran background music dan sound effect.

### Fitur Program
1. **Main Menu**
   - Menampilkan halaman awal dengan tombol **Start** untuk memulai permainan dan **Exit** untuk keluar dari program.
2. **Game Over**
   - Permainan berhenti ketika burung menabrak pipa atau jatuh hingga batas bawah area permainan.
3. **Restart**
   - Permainan dapat dimulai kembali dengan menekan tombol `R` setelah Game Over.
4. **Score System**
   - Skor ditampilkan menggunakan `JLabel` dan bertambah satu poin setiap kali burung berhasil melewati pipa.
5. **Audio**
   - Program dilengkapi background music dan/atau sound effect sebagai fitur bonus.
6. **Modifikasi Tampilan**
   - Tampilan game menggunakan tema pastel, burung yang digambar secara khusus, awan, serta pipa berwarna hijau pastel.

## 2. Penjelasan Alur Program
1. Program dijalankan melalui `App.java` dan menampilkan **Main Menu**.
2. Pemain menekan tombol **Start** untuk memulai permainan.
3. Burung bergerak mengikuti gravitasi dan dapat terbang ketika pemain menekan tombol `SPACE`.
4. Pipa bergerak sebagai rintangan yang harus dihindari pemain.
5. Setiap kali burung berhasil melewati pipa, skor bertambah satu poin dan ditampilkan pada `JLabel`.
6. Jika burung menabrak pipa atau jatuh hingga batas bawah area permainan, permainan berakhir dan menampilkan tulisan **Game Over**.
7. Setelah Game Over, pemain dapat menekan tombol `R` untuk mengulang permainan.
8. Pemain dapat keluar dari permainan melalui tombol **Exit** pada Main Menu.

## 3. Dokumentasi Program
Dokumentasi program berupa screenshot dan screen recording ketika game dijalankan disimpan pada folder `Dokumentasi/`.

### A. Main Menu
Tampilan awal program yang menampilkan judul Flappy Bird serta tombol Start dan Exit.

### B. Gameplay
Tampilan ketika permainan berlangsung. Pemain mengendalikan burung menggunakan tombol `SPACE` untuk menghindari pipa dan memperoleh skor.

### C. Game Over
Tampilan ketika permainan berakhir akibat burung menabrak pipa atau jatuh hingga batas bawah area permainan. Pemain dapat menekan tombol `R` untuk memulai ulang permainan.

### D. Screen Recording
Screen recording memperlihatkan alur permainan mulai dari Main Menu, gameplay, penambahan skor, Game Over, hingga restart.

## Cara Menjalankan Program
1. Buka project Flappy Bird menggunakan **IntelliJ IDEA**.
2. Pastikan seluruh file Java dan file audio tersedia.
3. Jalankan `App.java`.
4. Tekan tombol **Start** untuk memulai permainan.
5. Tekan `SPACE` untuk membuat burung terbang.
6. Hindari pipa untuk memperoleh skor.
7. Jika Game Over, tekan `R` untuk memulai ulang permainan.

## Kesimpulan
Program Flappy Bird dikembangkan dengan melengkapi fitur Game Over, restart, sistem skor, Main Menu, dan audio. Tampilan permainan juga dimodifikasi menggunakan tema pastel sebagai bentuk kreativitas dalam pengerjaan Tugas Praktikum 6.
