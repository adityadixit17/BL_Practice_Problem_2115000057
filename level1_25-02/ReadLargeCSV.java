package Day24.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\Downloads\\customers-1000.csv";
        int chunkSize = 100;
        try(CSVReader cr = new CSVReader(new FileReader(path))){
            String[] nextLine;
            int count = 0;
            int chunkCounter = 0;
            while ((nextLine = cr.readNext()) != null){
                System.out.println("Processing row: " + count + " - " + String.join(", ", nextLine));
                if(count % chunkSize == 0){
                    chunkCounter++;
                    System.out.println("Processed " + chunkCounter*chunkSize + " rows so far.");
                }
            }
        }catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
