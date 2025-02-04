class BankAccount {
    private static String bankName = "XYZ Bank";
    private static int totalAccounts = 0;
    
    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    
    // Constructor
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        totalAccounts++;
    }
    
    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Balance: " + this.balance);
        } else {
            System.out.println("Invalid account object.");
        }
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001, 5000.0);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002, 3000.0);
        
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        
        BankAccount.getTotalAccounts();
    }
}

