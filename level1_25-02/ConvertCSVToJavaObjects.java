package Day24.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private String grade;
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}

public class ConvertCSVToJavaObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\Students.csv";
        List<Student> students = readCSV(filePath);
        for(Student student : students){
            System.out.println(student);
        }
    }
    public static List<Student> readCSV(String filename){
        List<Student> students = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(filename))){
            String line[];
            reader.readNext();
            while((line = reader.readNext())!=null){
                String name = line[0];
                int age = Integer.parseInt(line[1]);
                String grade = line[2];
                students.add(new Student(name, age, grade));
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
        return students;
    }
}
