public class MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "success";
        char mostFrequentChar = findMostFrequentCharacter(str);
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        int[] frequency = new int[256];
        int maxCount = 0;
        char mostFrequentChar = '\0';

        int i = 0;
        while (true) {
            try {
                char c = str.charAt(i);
                frequency[c]++;

                if (frequency[c] > maxCount) {
                    maxCount = frequency[c];
                    mostFrequentChar = c;
                }
                i++;
            } catch (Exception e) {
                break;
            }
        }

        return mostFrequentChar;
    }
}

