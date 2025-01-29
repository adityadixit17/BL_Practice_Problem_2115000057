public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char charToRemove = 'l';
        String modifiedString = removeCharacter(str, charToRemove);
        System.out.println("Modified String: " + modifiedString);
    }

    public static String removeCharacter(String str, char charToRemove) {
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c != charToRemove) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}

