class Course {
    String courseName;
    int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}
public class CourseHierarchy {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 40, "Udemy", true, 50, 10);
        course.displayInfo();
    }
}
