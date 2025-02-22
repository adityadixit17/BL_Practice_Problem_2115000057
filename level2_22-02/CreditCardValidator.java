public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }
    public static void main(String[] args) {
        String cardNumber = "4123456789012345";
        System.out.println(isValidCreditCard(cardNumber) ? "Valid Credit Card" : "Invalid Credit Card");
    }
}
