import java.util.Map;
import java.util.Set;

public class Student {
    public String name;
    public String group;
    public int course;
    public Map<String, Double> grades;

    public Student(String name, String group, int course, Map<String, Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        } else {
            double sum = 0.0;
            for (double grade : grades.values()) {
                sum +=grade;
            }
            return sum / grades.size();
        }
    }

    public static void removeStudentsWithAverageGradeLess3(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void advanceStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.course++;
            }
        }
    }

    public static void  printStudents(Set<Student> students, int course) {
        System.out.println("Учащиеся на курсе " + course + ":");
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }
}
