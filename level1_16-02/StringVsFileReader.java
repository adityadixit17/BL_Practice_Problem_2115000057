import java.io.*;
public class StringVsFileReader {
    public static void main(String[] args) throws IOException {
        compareStringBuilderAndStringBuffer();
        countWordsInFile("file.txt");
    }
    public static void compareStringBuilderAndStringBuffer() {
        String text = "hello";
        int iterations = 1_000_000;
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long timeSB = System.nanoTime() - start;
        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }
        long timeSF = System.nanoTime() - start;
        System.out.println("StringBuilder time: " + timeSB / 1_000_000 + " ms");
        System.out.println("StringBuffer time: " + timeSF / 1_000_000 + " ms");
    }
    public static void countWordsInFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br.close();
        System.out.println("Total words in file: " + wordCount);
    }
}
