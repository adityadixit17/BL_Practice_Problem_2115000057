package Day24.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\employee.csv";
        Set<String> idSet = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();
        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] line;
            reader.readNext();
            while((line  = reader.readNext())!=null){
                String id = line[0].trim();
                if(!idSet.add(id)){
                    duplicateIds.add(id);
                    System.out.println("Duplicate Record Found: " + String.join("," , line));
                }
            }
            if(duplicateIds.isEmpty()){
                System.out.println("No Duplicate Record Found");
            }
            else {
                System.out.println("Duplicate Ids : " + String.join(",", duplicateIds));
            }
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
