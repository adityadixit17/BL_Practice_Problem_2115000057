package Day24.BasicProblems;

import com.opencsv.CSVWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\IdeaProjects\\BridgeLabs_Asssignments\\src\\main\\java\\Day24\\BasicProblems\\Employee.csv";
        System.out.println("Writing into CSV file using BufferWriter .... ");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write("ID,Name,Department,Salary\n");
            bw.write("1,Baibhavi,IT,30000\n");
            bw.write("2,Pooja,HR,25000\n");
            bw.write("3,Krishna,IT,30000\n");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nWriting into CSV file using OpenCSV .... ");
        try(CSVWriter writer = new CSVWriter(new FileWriter(filePath))){
            String[] emp1 = {"1","Khushi","IT","35000"};
            String[] emp2 = {"2","Baibhavi","IT","35000"};
            writer.writeNext(emp1);
            writer.writeNext(emp2);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
