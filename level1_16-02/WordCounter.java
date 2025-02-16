import java.io.*;
public class WordCounter {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("file.txt"));
		String targetWord = "I";
		int count = 0;
		String line;
		while((line = bf.readLine()) != null) {
			String[] words = line.split("\\s+");
			for(String word : words) {
				if(word.equals(targetWord)) {
					count++;
				}
			}
		}
		bf.close();
		System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
	}
}
