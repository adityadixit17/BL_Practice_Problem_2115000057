public class SubstringOccurrences {
    public static void main(String[] args) {
        String str = "hello world, hello everyone, hello universe";
        String substring = "hello";
        int count = countSubstringOccurrences(str, substring);
        System.out.println("The substring '" + substring + "' appears " + count + " times.");
    }

    public static int countSubstringOccurrences(String str, String substring) {
        char[] strArray = new char[1000];
        char[] subArray = new char[1000];
        int strLen = 0, subLen = 0;

        while (true) {
            try {
                strArray[strLen] = str.charAt(strLen);
                strLen++;
            } catch (Exception e) {
                break;
            }
        }

        while (true) {
            try {
                subArray[subLen] = substring.charAt(subLen);
                subLen++;
            } catch (Exception e) {
                break;
            }
        }

        int count = 0;
        for (int i = 0; i <= strLen - subLen; i++) {
            boolean match = true;
            for (int j = 0; j < subLen; j++) {
                if (strArray[i + j] != subArray[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }

        return count;
    }
}

