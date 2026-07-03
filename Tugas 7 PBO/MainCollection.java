import java.util.ArrayList;
import java.util.ArrayDeque;

public class MainCollection {
    public static void main(String[] args) {
        // Contoh ArrayList (Daftar berurutan)
        ArrayList<String> daftarNama = new ArrayList<>();
        daftarNama.add("Xiao");
        daftarNama.add("Wang");
        System.out.println("ArrayList (Daftar Nama): " + daftarNama);

        // Contoh ArrayDeque (Antrian/Stack)
        ArrayDeque<Integer> antrianNomor = new ArrayDeque<>();
        antrianNomor.addLast(101);
        antrianNomor.addLast(102);
        antrianNomor.push(100); // Menambah ke depan
        System.out.println("ArrayDeque (Antrian): " + antrianNomor);
    }
}