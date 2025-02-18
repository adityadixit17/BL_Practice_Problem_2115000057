import java.util.*;
abstract class CourseType {
    String name;
    CourseType(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}
class ExamCourse extends CourseType {
    ExamCourse() {
        super("Exam-Based");
    }
}
class AssignmentCourse extends CourseType {
    AssignmentCourse() {
        super("Assignment-Based");
    }
}
class ResearchCourse extends CourseType {
    ResearchCourse() {
        super("Research-Based");
    }
}
class Course<T extends CourseType> {
    String title;
    T courseType;   
    Course(String title, T courseType) {
        this.title = title;
        this.courseType = courseType;
    }
    void display() {
        System.out.println(title + " - " + courseType.getName());
    }
}
class CourseManager {
    static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getName());
        }
    }
}
public class UniversitySystem {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("History", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Physics", new ResearchCourse());       
        List<CourseType> courses = Arrays.asList(math.courseType, history.courseType, physics.courseType);
        CourseManager.displayCourses(courses);        
        math.display();
        history.display();
        physics.display();
    }
}
