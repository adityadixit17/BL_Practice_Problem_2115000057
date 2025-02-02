class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends BankAccount {
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}
public class Bank {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.accountNumber = "987654321";
        account.accountHolder = "Bob Smith";
        account.setBalance(5000.75);
        account.displayDetails();
        System.out.println("Balance: " + account.getBalance());
    }
}
