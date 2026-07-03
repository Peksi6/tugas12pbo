import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulasi Input Mahasiswa
        System.out.println("--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa: ");
        String sName = scanner.nextLine();
        System.out.print("Alamat Mahasiswa: ");
        String sAddress = scanner.nextLine();
        Student student = new Student(sName, sAddress);

        System.out.print("Berapa banyak nilai yang ingin dimasukkan? ");
        int nGrades = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < nGrades; i++) {
            System.out.print("Nama Mata Kuliah: ");
            String cName = scanner.nextLine();
            System.out.print("Nilai: ");
            int grade = scanner.nextInt();
            scanner.nextLine();
            student.addCourseGrade(cName, grade);
        }

        // Simulasi Input Dosen
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Nama Dosen: ");
        String tName = scanner.nextLine();
        System.out.print("Alamat Dosen: ");
        String tAddress = scanner.nextLine();
        Teacher teacher = new Teacher(tName, tAddress);

        System.out.print("Input Mata Kuliah yang diampu: ");
        String courseToTeach = scanner.nextLine();
        if (teacher.addCourse(courseToTeach)) {
            System.out.println("Berhasil menambahkan mata kuliah.");
        } else {
            System.out.println("Mata kuliah sudah ada.");
        }

        // Output Hasil
        System.out.println("\n--- Ringkasan Data ---");
        System.out.println(student.toString());
        student.printGrades();
        System.out.println("Rata-rata Nilai: " + student.getAverageGrade());

        System.out.println("\n" + teacher.toString());
        
        scanner.close();
    }
}