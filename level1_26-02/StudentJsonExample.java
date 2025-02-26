package D_26_02_25;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
class Student {
    private String name;
    private int age;
    private List<String> subjects;
    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public List<String> getSubjects() {
        return subjects;
    }
}
public class StudentJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = new Student("Aditya", 20, List.of("Mathematics", "Physics", "Computer Science"));
            String jsonString = objectMapper.writeValueAsString(student);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
