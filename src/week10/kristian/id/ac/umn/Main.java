package week10.kristian.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static ArrayList<Order> daftarOrder = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        daftarBarang.add(new Handphone("H001", "Samsung Galaxy", 5000000, 10));
        daftarBarang.add(new Handphone("H002", "iPhone 14", 12000000, 5));
        daftarBarang.add(new Voucher("V001", "Voucher Data 10GB", 100000, 0.1));
        daftarBarang.add(new Voucher("V002", "Voucher Game", 200000, 0.05));

        while (true) {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Tambah Barang Baru");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:
                    pesanBarang(input);
                    break;
                case 2:
                    lihatPesanan();
                    break;
                case 3:
                    tambahBarangBaru(input);
                    break;
                case 0:
                    System.out.println("Terima kasih sudah berbelanja!");
                    input.close(); 
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void pesanBarang(Scanner input) {
        System.out.println("\n=== Daftar Barang ===");
        for (Barang b : daftarBarang) {
            b.tampilkanInfo(); 
        }

        System.out.print("Masukkan ID Barang (0 untuk batal): ");
        String id = input.nextLine();

        if (id.equals("0")) return;

        Barang barangDipilih = null;
        for (Barang b : daftarBarang) {
            if (b.getId().equalsIgnoreCase(id)) {
                barangDipilih = b;
                break;
            }
        }

        if (barangDipilih == null) {
            System.out.println("Barang tidak tersedia!");
            return;
        }

        if (barangDipilih instanceof Handphone) {
            Handphone hp = (Handphone) barangDipilih; 
            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();
            input.nextLine();

            if (jumlah <= 0 || jumlah > hp.getStok()) {
                System.out.println("Jumlah tidak valid atau stok tidak cukup!");
                return;
            }

            double total = hp.getHarga() * jumlah;
            hp.kurangiStok(jumlah);
            daftarOrder.add(new Order(hp, jumlah, total));
            System.out.println("Pesanan berhasil ditambahkan!");

        } else if (barangDipilih instanceof Voucher) {
            Voucher vc = (Voucher) barangDipilih; 
            double total = vc.hitungHargaDenganPajak();
            
            daftarOrder.add(new Order(vc, 1, total));
            System.out.println("Pesanan berhasil ditambahkan!");
        }
    }

    private static void lihatPesanan() {
        System.out.println("\n=== Daftar Pesanan ===");
        if (daftarOrder.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (Order o : daftarOrder) {
                o.tampilkanOrder();
            }
        }
    }

    private static void tambahBarangBaru(Scanner input) {
        System.out.print("Masukkan jenis barang (1=Handphone, 2=Voucher): ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan ID: ");
        String id = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Harga/Nominal: ");
        double harga = input.nextDouble();
        input.nextLine();

        if (jenis == 1) {
            System.out.print("Masukkan Stok: ");
            int stok = input.nextInt();
            input.nextLine();
            daftarBarang.add(new Handphone(id, nama, harga, stok));
        } else if (jenis == 2) {
            System.out.print("Masukkan Pajak (misal 0.1 untuk 10%): ");
            double pajak = input.nextDouble();
            input.nextLine();
            daftarBarang.add(new Voucher(id, nama, harga, pajak));
        }
        System.out.println("Barang baru berhasil ditambahkan!");
    }
}