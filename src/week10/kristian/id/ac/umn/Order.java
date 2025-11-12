package week10.kristian.id.ac.umn;

public class Order {
    private Barang barang;
    private int jumlah;
    private double total;

    public Order(Barang barang, int jumlah, double total) {
        this.barang = barang;
        this.jumlah = jumlah;
        this.total = total;
    }

    public void tampilkanOrder() {
        System.out.println("--- Detail Pesanan ---");
        
        if (barang instanceof Handphone) {
            System.out.println("  Barang : " + barang.getNama() + " (Handphone)");
        } else if (barang instanceof Voucher) {
            System.out.println("  Barang : " + barang.getNama() + " (Voucher)");
        }
        
        System.out.println("  Jumlah : " + jumlah);
        System.out.println("  Total  : " + total);
        System.out.println("------------------------");
    }
}