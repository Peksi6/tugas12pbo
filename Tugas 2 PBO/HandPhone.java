public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan urutan modifier dan penggunaan 'this'
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Menambahkan return statement
    public String getJenisHP() {
        return jenis_hp;
    }

    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Memberikan nilai input saat memanggil method
        hp.setDataHP("Samsung S23", 2023);
        
        // Menampilkan hasil dengan System.out.println
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun Pembuatan: " + hp.getTahunPembuatan());
    }
}