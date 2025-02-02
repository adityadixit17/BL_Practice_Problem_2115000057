class Student {
    public int rollNumber;
    protected String name;
    protected double CGPA; 
}
class PostgraduateStudent extends Student {
    public void displayName() {
        System.out.println("Name: " + name);
    }
    public void modifyCGPA(double newCGPA) {
        CGPA = newCGPA; 
    }
    public void displayCGPA() {
        System.out.println("CGPA: " + CGPA); 
    }
}
public class University {
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent();
        pgStudent.rollNumber = 123;
        pgStudent.name = "John Doe";
        pgStudent.modifyCGPA(9.5);
        pgStudent.displayName();
        pgStudent.displayCGPA();
    }
}
