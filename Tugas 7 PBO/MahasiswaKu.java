// 1. Definisi Class Generic Mahasiswa (Jawaban Soal No. 1)
class Mahasiswa<T1, T2, T3> {
    private T1 nim;
    private T2 name;
    private T3 clas;

    // Setter untuk mengisi data
    public void setNim(T1 nim) {
        this.nim = nim;
    }

    public void setName(T2 name) {
        this.name = name;
    }

    public void setClas(T3 clas) {
        this.clas = clas;
    }

    // Getter untuk mengambil data
    public T1 getNim() {
        return nim;
    }

    public T2 getName() {
        return name;
    }

    public T3 getClas() {
        return clas;
    }
}

// 2. Class Utama sesuai dengan kode di gambar
public class MahasiswaKu {

    public static void main(String[] args) {
        // Membuat objek m dengan 3 tipe generic: String, String, dan Integer
        Mahasiswa<String, String, Integer> m = new Mahasiswa<>();

        // Mengatur nilai sesuai kode di gambar
        m.setNim("1102020");
        m.setName("Ferdi");
        m.setClas(21);

        // Menampilkan output
        System.out.println("NIM   : " + m.getNim());
        System.out.println("Nama  : " + m.getName());
        System.out.println("Kelas : " + m.getClas());
    }
}