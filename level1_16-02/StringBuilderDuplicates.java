import java.io.*;
import java.util.HashSet;
public class StringBuilderDuplicates {
	public static void main(String[] args) {
		String str = "Hi i am khushi gupta.";
		System.out.println("Original String: " + str);
		StringBuilder s = new StringBuilder();
		HashSet<Character> h = new HashSet<>();
		for(char ch : str.toCharArray()){
			if(!h.contains(ch)){
				h.add(ch);
				s.append(ch);	
			}
		}
		System.out.println("After Removing Duplicates: " + s.toString());
	}
}
