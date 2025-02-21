import java.io.*;
public class CaseConversion {
public static void main(String[] args) {
try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"UTF-8"));
BufferedWriter bfs = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"),"UTF-8"))){
String line;
while ((line = bf.readLine()) != null) {
bfs.write(line.toLowerCase());
bfs.newLine();
}
System.out.println("File copied successfully");
}catch(Exception e){
System.out.println(e.getMessage());
}
}
}
