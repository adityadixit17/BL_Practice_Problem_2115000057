package Day24.IntermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\IntermediateProblems\\Employee.csv";
        String serachName = "Khushi";
        try(CSVReader cr = new CSVReader(new FileReader(path))){
            String header[] = cr.readNext();
            boolean employeeFound = false;
            String[] line;
            while ((line = cr.readNext())!=null) {
                String name = line[0];
                String department = line[1];
                String salary = line[2];
                if(name.equalsIgnoreCase(serachName)){
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    employeeFound = true;
                    break;
                }
            }
            if (!employeeFound) {
                System.out.println("Employee not found.");
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
