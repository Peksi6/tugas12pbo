public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[10];

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) return false; // Sudah ada
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        int foundIndex = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false; // Tidak ditemukan
        
        // Geser array untuk menghapus
        for (int i = foundIndex; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }
        numCourses--;
        return true;
    }
}