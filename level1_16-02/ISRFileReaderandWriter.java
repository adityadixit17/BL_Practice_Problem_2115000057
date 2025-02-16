import java.io.*;
public class ISRFileReaderandWriter {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
		System.out.println("Enter text (type 'exit' to stop):");
        	String line;
		while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
           		bw.write(line);
                	bw.newLine();
        	}
        	br.close();
        	bw.close();
        	System.out.println("Input saved to file.txt");
	}
}
