package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\students.json"));
            List<JsonNode> filteredStudents = new ArrayList<>();
            if (rootNode.isArray()) {
                for (JsonNode student : rootNode) {
                    if (student.has("age") && student.get("age").asInt() > 25) {
                        filteredStudents.add(student);
                    }
                }
            }
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredStudents);
            System.out.println(filteredJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
