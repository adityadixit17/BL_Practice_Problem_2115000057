package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;
import java.io.IOException;
public class JsonValidation {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode.toString());
            JsonNode jsonData = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\data.json"));
            JsonValidator validator = factory.getValidator();
            ProcessingReport report = validator.validate((JsonNode) schema, jsonData);
            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON!");
                System.out.println(report);
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
