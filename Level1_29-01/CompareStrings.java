public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        compareStrings(str1, str2);
    }

    public static void compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        
        for (int i = 0; i < minLength; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 < c2) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
                return;
            } else if (c1 > c2) {
                System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
                return;
            }
        }
        
        if (str1.length() < str2.length()) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (str1.length() > str2.length()) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are equal");
        }
    }
}

