package Day24.IntermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortCSVRecord {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\IntermediateProblems\\Employee.csv";
        ArrayList<String[]> record = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] header = reader.readNext();
            record.add(header);
            String[] line;
            while((line = reader.readNext())!=null){
                record.add(line);
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
        Collections.sort(record.subList(1, record.size()), new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Double.compare(Double.parseDouble(o2[2]),Double.parseDouble(o1[2]));
            }
        });
        System.out.println(String.join("," , record.get(0)));
        for (int i = 1; i <= 5 && i < record.size(); i++) {
            System.out.println(String.join(",", record.get(i)));
        }
    }
}
