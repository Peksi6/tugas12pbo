import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "students.csv";
        String destFile = "students_copy.csv";
        String line;
        int jumlahBaris = 0;

        System.out.println("Memulai menyalin file dari: " + sourceFile);

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {

            // Membaca dari sumber dan langsung menulis ke tujuan
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                jumlahBaris++;
            }
            
            System.out.println("[Sukses] Proses selesai! Berhasil menyalin " + jumlahBaris + " baris ke " + destFile);

        } catch (IOException e) {
            System.out.println("[Gagal] Terjadi kesalahan saat menyalin file.");
            e.printStackTrace();
        }
    }
}