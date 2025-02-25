package Day24.BasicProblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPrintCSVData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\BasicProblems\\Student.csv";
        // buffer
        System.out.println("Fetching Data Using BufferReader: ");
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!= null){
                String[] cols = line.split(",");
                System.out.println("ID: " + cols[0] + ", Name: " + cols[1] + ", Age: " + cols[2] + ", Marks: " + cols[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // open csv
        System.out.println("\nFetching Data Using OpenCSV: ");
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] nextLine;
            while((nextLine = reader.readNext()) != null){
                System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
            }
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
