public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
        String reversedStr = reverse(str);
        System.out.println(reversedStr);
    }

    public static String reverse(String str) {
        char[] charArray = str.toCharArray();
        int n = 0;
        
        while (true) {
            try {
                char temp = charArray[n];
                n++;
            } catch (Exception e) {
                break;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1 - i] = temp;
        }

        String reversed = "";
        for (int i = 0; i < n; i++) {
            reversed += charArray[i];
        }

        return reversed;
    }
}

