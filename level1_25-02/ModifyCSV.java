package Day24.IntermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModifyCSV {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\IntermediateProblems\\Employee.csv";
        ArrayList<String[]> employeeRecords = new ArrayList<>();
        try(CSVReader cr = new CSVReader(new FileReader(path))){
            String[] header = cr.readNext();
            boolean departmentFound = false;
            String[] line;
            while ((line = cr.readNext())!=null){
                if(line[1].equalsIgnoreCase("IT")){
                    departmentFound = true;
                    double salary =Double.parseDouble(line[2]);
                    salary *= 1.10;
                    line[2] = String.valueOf(salary);
                }
                employeeRecords.add(line);
            }
            if(!departmentFound){
                System.out.println("No employee with IT department found");
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
        try(CSVWriter cw = new CSVWriter(new FileWriter(path))){
            cw.writeAll(employeeRecords);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
