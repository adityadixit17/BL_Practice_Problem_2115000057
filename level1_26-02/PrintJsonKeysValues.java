package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\data.json"));
            printJson(rootNode, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), parentKey.isEmpty() ? field.getKey() : parentKey + "." + field.getKey());
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "]");
            }
        } else {
            System.out.println(parentKey + " : " + node.asText());
        }
    }
}
