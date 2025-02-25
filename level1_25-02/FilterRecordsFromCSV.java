package Day24.IntermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\IntermediateProblems\\Student.csv";
        try(CSVReader reader = new CSVReader(new FileReader(path))){
           String[] header = reader.readNext();
           if(header!=null){
               System.out.println(String.join("," , header));
           }
            String line[];
           while((line = reader.readNext())!=null){
               String name = line[0];
               int score =  Integer.parseInt(line[1]);
               if(score > 80){
                   System.out.println(name + "," + score);
               }
           }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
