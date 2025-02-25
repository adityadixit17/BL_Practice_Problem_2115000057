package Day24.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVs {
    public static void main(String[] args) throws IOException {
        String students1 = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\students1.csv";
        String students2 = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\students2.csv";
        String mergedFile = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\MergedCsvFile.csv";
        Map<String, String[]> students1Data = new HashMap<>();
        Map<String, String[]> students2Data = new HashMap<>();
        try(CSVReader cr = new CSVReader(new FileReader(students1))){
            String[] line;
            cr.readNext();
            while((line = cr.readNext())!= null){
                String id = line[0];
                students1Data.put(id, line);
            }
        }catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        try(CSVReader cr = new CSVReader(new FileReader(students2))){
            String[] line;
            cr.readNext();
            while((line = cr.readNext())!= null){
                String id = line[0];
                students2Data.put(id, line);
            }
        }catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        try(CSVWriter cw = new CSVWriter(new FileWriter(mergedFile))){
            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            cw.writeNext(header);
            for(String id : students1Data.keySet()){
                String [] student1 = students1Data.get(id);
                String [] student2 = students2Data.get(id);
                if(students2 != null){
                    String[] mergedRow = {
                            student1[0], student1[1], student1[2], student2[0], student2[1]
                    };
                    cw.writeNext(mergedRow);
                }
            }
            System.out.println("Merged CSV file created successfully: " + mergedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
