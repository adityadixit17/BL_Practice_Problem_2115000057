public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        compareStrings(str1, str2);
    }

    public static void compareStrings(String str1, String str2) {
        char[] arr1 = new char[1000];
        char[] arr2 = new char[1000];
        int len1 = 0, len2 = 0;

        while (true) {
            try {
                arr1[len1] = str1.charAt(len1);
                len1++;
            } catch (Exception e) {
                break;
            }
        }

        while (true) {
            try {
                arr2[len2] = str2.charAt(len2);
                len2++;
            } catch (Exception e) {
                break;
            }
        }

        int minLength = (len1 < len2) ? len1 : len2;

        for (int i = 0; i < minLength; i++) {
            if (arr1[i] < arr2[i]) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
                return;
            } else if (arr1[i] > arr2[i]) {
                System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
                return;
            }
        }

        if (len1 < len2) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (len1 > len2) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are equal");
        }
    }
}

