package D_26_02_25;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\main\\java\\D_26_02_25\\data.json"));
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
