import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa {
    String nim, nama, grade, status;
    int nilai;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A"; status = "lulus";
        } else if (nilai >= 70) {
            grade = "B"; status = "lulus";
        } else if (nilai >= 60) {
            grade = "C"; status = "lulus";
        } else if (nilai >= 50) {
            grade = "D"; status = "tidak lulus";
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E"; status = "tidak lulus";
        } else {
            grade = "Invalid";
        }
    }
}

public class ProgramNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMhs = new ArrayList<>();
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = scanner.nextInt();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : "); String nim = scanner.next();
            System.out.print("Nama  : "); String nama = scanner.next();
            System.out.print("Nilai : "); double nilai = scanner.nextDouble();

            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah");
                i--; // Ulangi input untuk mahasiswa ini
            } else {
                daftarMhs.add(new Mahasiswa(nim, nama, nilai));
            }
        }

        // Output Header
        System.out.println("\n-------------------------------------------");
        double totalNilai = 0;
        int lulus = 0, tdkLulus = 0;
        
        for (Mahasiswa m : daftarMhs) {
            System.out.println("NIM   : " + m.nim);
            System.out.println("Nama  : " + m.nama);
            System.out.println("Nilai : " + m.nilai);
            System.out.println("Grade : " + m.grade);
            System.out.println("-------------------------------------------");
            
            totalNilai += m.nilai;
            if (m.status.equals("lulus")) lulus++;
            else tdkLulus++;
        }

        // Ringkasan
        System.out.println("Jumlah Mahasiswa : " + daftarMhs.size());
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tdkLulus);
        System.out.printf("Rata-rata nilai mahasiswa adalah: %.2f\n", (totalNilai / daftarMhs.size()));
    }
}