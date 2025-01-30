public class WordReplace {
    public static void main(String[] args) {
        String sentence = "Java is a powerful language.";
        String wordToReplace = "powerful";
        String replacementWord = "versatile";

        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < sentence.length()) {
            int j = 0;
            while (i + j < sentence.length() && j < wordToReplace.length() && sentence.charAt(i + j) == wordToReplace.charAt(j)) {
                j++;
            }

            if (j == wordToReplace.length()) {
                result.append(replacementWord);
                i += wordToReplace.length();
            } else {
                result.append(sentence.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}

