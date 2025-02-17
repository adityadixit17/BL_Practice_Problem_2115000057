import java.io.*;
public class FileReadingTest {
    public static void main(String[] args) throws IOException {
        String filePath = "file.txt";  
        long start = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - start;
        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + fileReaderTime / 1e6 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1e6 + " ms");
    }
    static void readUsingFileReader(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            while (reader.read(buffer) != -1);
        }
    }
    static void readUsingInputStreamReader(String filePath) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[1024];
            while (reader.read(buffer) != -1);
        }
    }
}
