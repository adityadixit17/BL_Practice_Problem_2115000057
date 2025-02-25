package Day24.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String emailFormat = "^[a-zA-Z0-9_+-.]+@[a-zA-Z0-9-]+\\.[A-Za-z]{2,}$";
        String phoneNumFormat = "[6-9]\\d{9}";
        Pattern emailPattern = Pattern.compile(emailFormat);
        Pattern phonePattern = Pattern.compile(phoneNumFormat);
        String path = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\AdavnceProblems\\Emplyee.csv";
        try (CSVReader cr = new CSVReader(new FileReader(path))) {
            String[] header = cr.readNext();
            if (header != null) {
                System.out.println(String.join(",", header));
            }

            String[] line;
            while ((line = cr.readNext()) != null) {
                String email = line[2];
                String phoneNum = line[3];
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email: " + String.join(",", line));
                } else if (!phonePattern.matcher(phoneNum).matches()) {
                    System.out.println("Invalid Phone Number: " + String.join(",", line));
                } else {
                    System.out.println("Valid: " + String.join(",", line));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
