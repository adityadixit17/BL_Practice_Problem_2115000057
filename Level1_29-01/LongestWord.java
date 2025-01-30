import java.io.*;

public class LongestWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a sentence: ");
        String sentence = reader.readLine();
        String longestWord = findLongestWord(sentence);
        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String sentence) {
        char[] charArray = new char[1000];
        int n = 0;

        while (true) {
            try {
                charArray[n] = sentence.charAt(n);
                n++;
            } catch (Exception e) {
                break;
            }
        }

        String longestWord = "";
        String currentWord = "";
        
        for (int i = 0; i < n; i++) {
            if (charArray[i] != ' ') {
                currentWord += charArray[i];
            } else {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = "";
            }
        }

        if (currentWord.length() > longestWord.length()) {
            longestWord = currentWord;
        }

        return longestWord;
    }
}

