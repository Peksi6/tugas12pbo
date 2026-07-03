import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        String csvSplitBy = ",";
        int indeks = 0;
        
        System.out.println("NIM, NAMA, UMUR, PRODI");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    // Menampilkan data (melanjutkan potongan kode asli yang terpotong)
                    if (student.length >= 4) {
                        System.out.println(student[0] + ", " + student[1] + ", " + student[2] + ", " + student[3]);
                    }
                }
            }
            
            // MENAMPILKAN HASIL JUMLAH BARIS
            System.out.println("\n------------------------------------");
            System.out.println("Total baris seluruhnya (termasuk header): " + indeks);
            System.out.println("Total baris data mahasiswa: " + (indeks > 0 ? (indeks - 1) : 0));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}