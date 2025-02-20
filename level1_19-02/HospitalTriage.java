import java.util.*;

public class HospitalTriage {
    


public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity) );

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll().name);
        }

}  
  }
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
