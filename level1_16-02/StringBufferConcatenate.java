import java.io.*;
public class StringBufferConcatenate {
	public static void main(String[] args) throws IOException {
		String[] str = {"Khushi", "Piyush", "Aditya", "Krishna"};
		StringBuffer sb = new StringBuffer();
		for(String s : str) {
			sb.append(s);
		}	
	        System.out.print("Array of Strings: ");
        	for (String word : str) {
            		System.out.print(word + " ");
  		}
		System.out.println();		
		System.out.println("Concatenated String: " + sb.toString());
	}
}
