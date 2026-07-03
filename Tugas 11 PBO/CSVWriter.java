import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "new_students.csv";
        
        // Membuka file dengan mode append (true) agar data baru tidak menghapus data lama
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true)); 
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Membersihkan sisa newline di memori input
            
            for (int i = 0; i < jumlah; i++) {
                System.out.println("\n--- Data Mahasiswa ke-" + (i + 1) + " ---");
                System.out.print("Masukkan NIM  : ");
                String nim = scanner.nextLine();
                
                System.out.print("Masukkan Nama : ");
                String nama = scanner.nextLine();
                
                System.out.print("Masukkan Umur : ");
                String umur = scanner.nextLine();
                
                // Menggabungkan input menjadi format satu baris CSV
                String line = nim + "," + nama + "," + umur;
                
                // Menulis ke file
                bw.write(line);
                bw.newLine();
            }
            
            System.out.println("\n[Sukses] Data berhasil ditambahkan ke " + csvFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}