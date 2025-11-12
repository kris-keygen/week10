package week10.kristian.id.ac.umn;

public class Handphone extends Barang {
    private int stok;

    public Handphone(String id, String nama, double harga, int stok) {
        super(id, nama, harga);
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + id + " | Tipe: Handphone | Nama: " + nama + " | Harga: " + harga + " | Stok: " + stok);
    }
}
