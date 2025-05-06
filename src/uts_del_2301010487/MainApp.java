package uts_del_2301010487;

import java.util.Scanner;

class Mahasiswa {
    private int id;
    private String nama;
    private String jurusan;

    // Constructor default
    public Mahasiswa() {
        this.id = 0;
        this.nama = "";
        this.jurusan = "";
    }

    // Constructor overloading
    public Mahasiswa(int id, String nama, String jurusan) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    // Method untuk menampilkan data
    public void display() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", Jurusan: " + jurusan);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }
}

public class MainApp {
    static Scanner input = new Scanner(System.in);
    static Mahasiswa[] data = new Mahasiswa[100];
    static int count = 0;

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n--- MENU APLIKASI MAHASISWA ---");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    ubahData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Keluar aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    public static void tambahData() {
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();

        data[count] = new Mahasiswa(id, nama, jurusan);
        count++;
        System.out.println("Data berhasil ditambahkan.");
    }

    public static void tampilData() {
        if (count == 0) {
            System.out.println("Belum ada data.");
        } else {
            for (int i = 0; i < count; i++) {
                data[i].display();
            }
        }
    }

    public static void ubahData() {
        System.out.print("Masukkan ID Mahasiswa yang ingin diubah: ");
        int id = input.nextInt();
        input.nextLine();
        int index = cariIndexById(id);
        if (index == -1) {
            System.out.println("Data tidak ditemukan.");
        } else {
            System.out.print("Nama baru: ");
            String nama = input.nextLine();
            System.out.print("Jurusan baru: ");
            String jurusan = input.nextLine();

            data[index].setNama(nama);
            data[index].setJurusan(jurusan);
            System.out.println("Data berhasil diubah.");
        }
    }

    public static void hapusData() {
        System.out.print("Masukkan ID Mahasiswa yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();
        int index = cariIndexById(id);
        if (index == -1) {
            System.out.println("Data tidak ditemukan.");
        } else {
            for (int i = index; i < count - 1; i++) {
                data[i] = data[i + 1];
            }
            data[count - 1] = null;
            count--;
            System.out.println("Data berhasil dihapus.");
        }
    }

    public static int cariIndexById(int id) {
        for (int i = 0; i < count; i++) {
            if (data[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
