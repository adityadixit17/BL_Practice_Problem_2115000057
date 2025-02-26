package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class JsonFieldExtractor {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\data.json"));
            String name = jsonNode.get("name").asText();
            String email = jsonNode.get("email").asText();
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
