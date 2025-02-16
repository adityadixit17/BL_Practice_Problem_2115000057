import java.io.*;
public class ByteStreamToCharacterStream {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt"), "UTF-8"));
		String line;
	        while ((line = bf.readLine()) != null) {
        		System.out.println(line);
        	}
        	bf.close();
	}
}
