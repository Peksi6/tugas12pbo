import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMerge {
    public static void main(String[] args) {
        // Menggunakan jalur file relatif agar menyatu dalam satu folder
        String[] files = {"teks1.txt", "teks2.txt"};
        String mergedFile = "merge.txt";

        System.out.println("Memulai proses penggabungan file...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFile))) {
            for (String file : files) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Gagal membaca file: " + file);
                    e.printStackTrace();
                }
            }
            System.out.println("[Sukses] File berhasil digabungkan ke: " + mergedFile);

        } catch (IOException e) {
            System.out.println("Gagal menulis ke file tujuan.");
            e.printStackTrace();
        }
    }
}