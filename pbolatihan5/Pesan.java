
public class Pesan {
     String nama, gula;
    Integer harga, qty;

    public String getNama() {
        return nama;
    }

    public String getGula() {
        return gula;
    }

    public Integer getHarga() {
        return harga;
    }

    public Integer getQty() {
        return qty;
    }

    public Pesan(String nama, String gula, Integer harga, Integer qty) {
        this.nama = nama;
        this.gula = gula;
        this.harga = harga;
        this.qty = qty;
    }
}
