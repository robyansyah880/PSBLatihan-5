
import java.util.ArrayList;
import java.util.Scanner;

public class PBOLatihan5 {
private static int totBayar=0;

    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        Integer pilih=0;

        ArrayList<Pesan> listPesan=new ArrayList();
        do{
            System.out.println("=================================");
            System.out.println("         BINTANG BUCK COFFEE        ");
            System.out.println("=================================");
            System.out.println("          1. Pesanan");
            System.out.println("          2. Pembayaran");
            System.out.println("          3. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih 1, 2 atau 3 :");
            pilih = sc.nextInt();

            if(pilih == 1){
              //Masukan Pesanan
                listPesan = beli(listPesan);
            }else if(pilih==2){
                //View Pesanan
                listPesan = bayar(listPesan);
                int totalBayar = totBayar;
                if(totalBayar > 0){
                    System.out.println("Bayar:");
                    Integer jmlUang = sc.nextInt();
                    Integer JumlahUang = jmlUang;
                    if (JumlahUang < totalBayar){
                        do {
                            System.out.println("Uang Anda Kurang");
                            System.out.println("================");
                            System.out.println("Jumlah Uang :");
                            jmlUang = sc.nextInt();
                        }while (JumlahUang < totalBayar);

                        System.out.println("Kembalian : "+(JumlahUang-totalBayar));
                    }else{
                        System.out.println("Kembalian : "+(JumlahUang-totalBayar));
                    }
                    listPesan.clear();
                }
            }
        }while (pilih != 3);
    }

    private static ArrayList<Pesan> beli(ArrayList<Pesan> listPesan) {
        String nama,gula;
        Integer harga,qty;
        Scanner sc=new Scanner(System.in);

        System.out.println("Nama Minuman : ");
        nama = sc.nextLine();
        if(!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte")
                && !nama.equalsIgnoreCase("arabika")){
            do{
                System.out.println("Nama Pesanan Tidak Sesuai");
                System.out.println("=========================");
                System.out.println("Nama : ");
                nama = sc.nextLine();
            }while(!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte")
                    && !nama.equalsIgnoreCase("arabika"));
        }
        System.out.println("Level Gula :");
        gula = sc.nextLine();
        System.out.println("Harga Minuman : ");
        harga = sc.nextInt();
        System.out.println("Jumlah Yang Dibeli : ");
        qty = sc.nextInt();
        if(qty <= 0){
            do{
                System.out.println("Jumlah minimal 1 ");
                System.out.println("=================");
                System.out.println("Jumlah : ");
                qty = sc.nextInt();
            }while (qty <= 0);
        }

        listPesan.add(new Pesan(nama,gula,harga,qty));

        return listPesan;
    }

    private static ArrayList<Pesan> bayar(ArrayList<Pesan> listPesan) {
        Scanner sc=new Scanner(System.in);
        totBayar = 0;
        System.out.println("==================================================================");
        System.out.printf("| %-10s | %-5s | %-7s | %-7s | %-7s |",
                "Nama",
                "Gula",
                "Harga",
                "Jumlah Barang",
                "Total" );
        System.out.println();
        System.out.println("==================================================================");

        for (int i = 0; i < listPesan.size(); i++) {
            System.out.printf("| %-7s  | %-5s  | %-7s  | %-7s  | %-7s |",
                    listPesan.get(i).getNama(),
                    listPesan.get(i).getGula(),
                    listPesan.get(i).getHarga(),
                    listPesan.get(i).getQty(),
                    (listPesan.get(i).getHarga()*listPesan.get(i).getQty()));
            totBayar = totBayar+(listPesan.get(i).getHarga()*listPesan.get(i).getQty());
            System.out.println();
            System.out.println("==================================================================--");

        }
        System.out.println("Harga Jual : "+totBayar);

        if(totBayar==0){
            System.out.println("Tekan Enter...");
            sc.nextLine();
        }

        return  listPesan;
        
    }
    
}
