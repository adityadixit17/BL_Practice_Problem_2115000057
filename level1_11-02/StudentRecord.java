import java.util.*;
class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentLinkedList {
    private StudentNode head;
    public StudentLinkedList() {
        head = null;
    }
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student of roll number " + rollNumber + " data has been deleted.");
	    return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
	    System.out.println("Student of roll number " + rollNumber + " data has been deleted.");
        }
        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }
	System.out.println("Student of roll number " + rollNumber + " data has been deleted.");
        temp.next = temp.next.next;
    }
    public StudentNode searchStudentByRollNumber(int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void updateStudentGrade(int rollNumber, char newGrade) {
        StudentNode student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
	    System.out.println("Student with roll number " + rollNumber + " grade has been updated.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public void displayAllStudents() {
        StudentNode temp = head;
        if (temp == null) {
            System.out.println("No students to display.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}
public class StudentRecord {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addStudentAtBeginning(1, "Khushi", 20, 'A');
        list.addStudentAtEnd(2, "Piyush", 21, 'B');
        list.addStudentAtEnd(4, "Pooja", 22, 'C');
        list.addStudentAtPosition(3, "Krishna", 23, 'B', 2);
        list.displayAllStudents();
        list.deleteStudentByRollNumber(2);
        list.displayAllStudents();
        StudentNode student = list.searchStudentByRollNumber(3);
        if (student != null) {
            System.out.println("Student found: " + student.name);
        } else {
            System.out.println("Student not found.");
        }
        list.updateStudentGrade(1, 'A');
        list.displayAllStudents();
    }
}

