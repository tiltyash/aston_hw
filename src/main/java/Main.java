import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Александр Трякин", "Группа 1", 1, Map.of("Мат. анализ", 2.8,
                "Основы программирования, язык Си", 2.5)));
        students.add(new Student("Ольга Бузова", "Группа 1", 1, Map.of("Мат. анализ", 3.0,
                "Основы программирования, язык Си", 3.1)));
        students.add(new Student("Евгений Левко", "Группа 2", 2, Map.of("Эконометрика", 4.4,
                "Микроэконимка", 4.7)));
        students.add(new Student("Югий Спасокукоцкий", "Группа 4", 3, Map.of("Менеджмент", 5.0,
                "Бухучет", 4.2)));

        Student.removeStudentsWithAverageGradeLess3(students);
        Student.advanceStudents(students);
        Student.printStudents(students, 2);

        /////////////////////////

        ContactList contactList = new ContactList();

        contactList.add("Иванов", "8 923 111 222 333");
        contactList.add("Петухов", "8 923 222 333 444");
        contactList.add("Лопухов", "8 923 333 444 555");
        contactList.add("Тюхин", "8 923 444 555 666");
        contactList.add("Иванов", "8 923 555 666 777");

        System.out.println("Иванов\t" + contactList.get("Иванов"));
        System.out.println("Петухов\t" + contactList.get("Петухов"));
        System.out.println("Лопухов\t" + contactList.get("Лопухов"));
        System.out.println("Распутин\t" + contactList.get("Распутин"));
    }
}
