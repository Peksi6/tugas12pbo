public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = new String[30]; // Kapasitas 30 mata kuliah
    private int[] grades = new int[30];

    public Student(String name, String address) {
        super(name, address);
    }

    // Solusi Error: addCourseGrade
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    // Solusi Error: printGrades
    public void printGrades() {
        System.out.print("Daftar Nilai: ");
        for (int i = 0; i < numCourses; i++) {
            System.out.print(courses[i] + ":" + grades[i] + " ");
        }
        System.out.println();
    }

    // Solusi Error: getAverageGrade
    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Mahasiswa: " + super.toString() + " | Jumlah MK: " + numCourses;
    }
}