class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayRole() {
        System.out.println("This is a person.");
    }
}
class Teacher extends Person {
    String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Person teacher = new Teacher("Mr. Smith", 40, "Math");
        Person student = new Student("Alice", 16, "10th Grade");
        Person staff = new Staff("Mr. John", 45, "Administration");
        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}
