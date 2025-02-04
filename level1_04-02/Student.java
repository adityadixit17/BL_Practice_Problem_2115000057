class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    
    private final int rollNumber;
    private String name;
    private char grade;
    
    // Constructor
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    
    // Method to display student details
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }
    
    // Method to update grade
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + this.name);
        } else {
            System.out.println("Invalid student object. Cannot update grade.");
        }
    }
    
    public static void main(String[] args) {
        Student student1 = new Student("Alice Brown", 101, 'A');
        Student student2 = new Student("Bob Smith", 102, 'B');
        
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        
        displayTotalStudents();
        
        student2.updateGrade('A');
        student2.displayStudentDetails();
    }
}

