import java.io.*;
public class StringBuilderReverse {
	public static void main(String[] args) {
		String a = "khushi";
		System.out.println("Original String: " + a);
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		sb.reverse();
		System.out.println("Reversed String: " + sb.toString());
	}
}
