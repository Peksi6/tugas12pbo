public class Bank {

    // variasi 1: transfer sesama bank
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan);
    }

    // variasi 2: transfer antar bank berbeda
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ")");
    }

    // variasi 3: transfer dengan pesan/berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ") | Pesan: " + berita);
    }

    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // fitur tambahan hitung biaya transfer
    public int hitungBiaya(String bankTujuan) {
        return (bankTujuan.equalsIgnoreCase("BNI") || bankTujuan.equalsIgnoreCase("BCA")) ? 0 : 6500;
    }

    static class BankBNI extends Bank {
        @Override
        public void sukuBunga() {
            System.out.println("Suku Bunga dari BNI adalah: 4%");
        }

        @Override
        public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
            bankTujuan = "BNI"; 
            System.out.println("[BNI] Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ")");
        }
    }

    static class BankBCA extends Bank {
        @Override
        public void sukuBunga() {
            System.out.println("Suku Bunga dari BCA adalah: 4.5%");
        }

        @Override
        public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
            bankTujuan = "BCA";
            System.out.println("[BCA] Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (" + bankTujuan + ")");
        }
    }

    public static void main(String[] args) {
        Bank bankPusat = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        // uji coba method overloading
        bankPusat.transferUang(100000, "111222");
        bankPusat.transferUang(200000, "333444", "MANDIRI");
        bankPusat.transferUang(300000, "555666", "BRI", "Bayar Kost");
        bankPusat.sukuBunga();

        System.out.println(); // spasi baris

        // uji coba method overriding
        bni.sukuBunga();
        bni.transferUang(500000, "999000", "BJB"); 
        
        bca.sukuBunga();
        bca.transferUang(750000, "888777", "MANDIRI");

        System.out.println();

        // cek bonus challenge
        String tujuan = "MANDIRI";
        System.out.println("Transfer ke " + tujuan + " kena biaya: Rp" + bankPusat.hitungBiaya(tujuan));
    }
}