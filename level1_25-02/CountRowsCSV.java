package Day24.BasicProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\BasicProblems\\Student.csv";
        System.out.println("Counting Rows Using BufferReader: ");
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int count = 0;
            while((line = br.readLine())!= null){
                String[] cols = line.split(",");
                System.out.println("ID: " + cols[0] + ", Name: " + cols[1] + ", Age: " + cols[2] + ", Marks: " + cols[3]);
                count++;
            }
            System.out.println(count-1 + " Rows");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nCounting Rows Using OpenCSV: ");
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] nextLine;
            int count = 0;
            while((nextLine = reader.readNext()) != null){
                System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
                count++;
            }
            System.out.println(count-1 + " Rows");
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
