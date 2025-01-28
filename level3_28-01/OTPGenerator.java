import java.util.HashSet;

public class OTPGenerator {
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000); // Generates a number between 100000 and 999999
    }
    public static boolean validateUniqueOTPs(int[] otpArray) {
        HashSet<Integer> otpSet = new HashSet<>();
        for (int otp : otpArray) {
            if (!otpSet.add(otp)) { // If duplicate is found, return false
                return false;
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }
        boolean areUnique = validateUniqueOTPs(otpArray);
        if (areUnique) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}

