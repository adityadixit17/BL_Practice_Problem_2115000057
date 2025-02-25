package Day24.AdvanceProblems;

import com.opencsv.CSVWriter;
import org.objectweb.asm.TypeReference;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonCsvConversion {
    public static <ObjectMapper> void main(String[] args) {
        String jsonFilePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\students1.csv";
        String csvFilePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Map<String, Object>> students = mapper.readValue(new File(jsonFilePath), new TypeReference<>() {});
            CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath));
            csvWriter.writeNext(new String[]{"ID", "Name", "Age", "Marks"});
            for (Map<String, Object> student : students) {
                String[] row = new String[]{
                        student.get("id").toString(),
                        student.get("name").toString(),
                        student.get("age").toString(),
                        student.get("marks").toString()
                };
                csvWriter.writeNext(row);
            }
            csvWriter.close();
            System.out.println("JSON successfully converted to CSV.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
