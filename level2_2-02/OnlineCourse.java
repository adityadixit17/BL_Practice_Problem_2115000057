import java.util.*;
public class OnlineCourse {
    String courseName;
    int duration;
    double fee;
    static String instituteName;
    public OnlineCourse(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute Name: " + instituteName);
    }
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        OnlineCourse c1 = new OnlineCourse("Java Programming", 3, 300.0);
        OnlineCourse c2 = new OnlineCourse("Data Science", 6, 600.0);
        OnlineCourse.updateInstituteName("Tech Academy");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
