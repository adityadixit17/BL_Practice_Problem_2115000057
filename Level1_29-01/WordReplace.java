public class WordReplace {
    public static void main(String[] args) {
        String sentence = "Java is a powerful language.";
        String wordToReplace = "powerful";
        String replacementWord = "versatile";

        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replace(wordToReplace, replacementWord);
    }
}

