package week10.kristian.id.ac.umn;

public abstract class Barang {
    protected String id;
    protected String nama;
    protected double harga; 

    public Barang(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract void tampilkanInfo();
}
