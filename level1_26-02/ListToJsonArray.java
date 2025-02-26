package D_26_02_25;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
class Student1 {
    private String name;
    private int age;
    private String[] subjects;
    public Student1(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String[] getSubjects() { return subjects; }
}
public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Student1> students = Arrays.asList(
                    new Student1("Archi", 20, new String[]{"Math", "Science"}),
                    new Student1("Mayank", 22, new String[]{"History", "English"})
            );
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
