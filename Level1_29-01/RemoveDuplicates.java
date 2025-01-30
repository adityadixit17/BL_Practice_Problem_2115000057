public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);

        System.out.println("Original string: " + input);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        char[] resultArray = new char[1000];
        char[] charArray = new char[1000];
        int n = 0;

        while (true) {
            try {
                charArray[n] = str.charAt(n);
                n++;
            } catch (Exception e) {
                break;
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (charArray[i] == resultArray[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                resultArray[index++] = charArray[i];
            }
        }

        String result = "";
        for (int i = 0; i < index; i++) {
            result += resultArray[i];
        }

        return result;
    }
}

