package week10.kristian.id.ac.umn;

public class Voucher extends Barang {
    private double pajak;

    public Voucher(String id, String nama, double harga, double pajak) {
        super(id, nama, harga);
        this.pajak = pajak;
    }

    public double hitungHargaDenganPajak() {
        return harga + (harga * pajak);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + id + " | Tipe: Voucher   | Nama: " + nama + " | Nominal: " + harga + " | Harga Jual: " + hitungHargaDenganPajak());
    }
}
