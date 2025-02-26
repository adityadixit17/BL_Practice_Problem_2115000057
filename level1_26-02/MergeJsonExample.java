package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json1 = "{ \"name\": \"Archi\", \"age\": 22 }";
            String json2 = "{ \"email\": \"archi@example.com\", \"city\": \"Archi\" }";
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) node1);
            mergedJson.setAll((ObjectNode) node2);
            System.out.println(mergedJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

