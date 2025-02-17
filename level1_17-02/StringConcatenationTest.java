public class StringConcatenationTest {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            String[] data = new String[size];
            for (int i = 0; i < size; i++) data[i] = "test";
            long start = System.nanoTime();
            String result = "";
            for (String s : data) result += s;
            long stringTime = System.nanoTime() - start;
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (String s : data) sb.append(s);
            long stringBuilderTime = System.nanoTime() - start;
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (String s : data) sbf.append(s);
            long stringBufferTime = System.nanoTime() - start;
            System.out.println("Size: " + size +
                               ", String: " + stringTime / 1e6 + " ms" +
                               ", StringBuilder: " + stringBuilderTime / 1e6 + " ms" +
                               ", StringBuffer: " + stringBufferTime / 1e6 + " ms");
        }
    }
}
