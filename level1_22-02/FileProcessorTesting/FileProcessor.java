import java.io.*;
public class FileProcessor{
public void writeToFile(String filename, String content) throws IOException {
try (BufferedWriter bf = new BufferedWriter(new FileWriter("output.txt"))) {
bf.write(content);
}
}
public String readFromFile(String filename) throws IOException {
StringBuilder c=new StringBuilder();
try (BufferedReader br=new BufferedReader(new FileReader("input.txt"))) {
String line;
while((line=br.readLine())!=null){
c.append(line).append("\n");
}
}
return c.toString().trim();
}
}
