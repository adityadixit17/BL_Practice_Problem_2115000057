public class ToggleCase {
    public static void main(String[] args) {
        String str = "Hello World!";
        String result = toggleCase(str);
        System.out.println("Original string: " + str);
        System.out.println("Toggled string: " + result);
    }

    public static String toggleCase(String str) {
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

        char[] toggledArray = new char[n];

        for (int i = 0; i < n; i++) {
            if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                toggledArray[i] = (char) (charArray[i] + ('a' - 'A'));
            } else if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                toggledArray[i] = (char) (charArray[i] - ('a' - 'A'));
            } else {
                toggledArray[i] = charArray[i];
            }
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            result += toggledArray[i];
        }

        return result;
    }
}

