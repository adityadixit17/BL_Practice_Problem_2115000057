package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;
public class ValidateJsonEmail {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\schema.json"));
            JsonNode jsonData = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\data.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);
            JsonValidator validator = factory.getValidator();
            if (validator.validate((JsonNode) schema, jsonData).isSuccess()) {
                System.out.println("Valid JSON");
            } else {
                System.out.println("Invalid JSON");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
