import java.io.*;
public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("file.txt"));
        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
        bf.close();
    }
}

