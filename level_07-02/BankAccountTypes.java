class BankAccount {
    String accountNumber;
    double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayAccountType() {
        System.out.println("This is a general bank account.");
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        System.out.println("This is a Savings Account with interest rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        System.out.println("This is a Checking Account with a withdrawal limit of: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    int tenure;
    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }
    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account with tenure of: " + tenure + " months");
    }
}
public class BankAccountTypes {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA123", 5000, 4);
        BankAccount checking = new CheckingAccount("CA456", 2000, 1500);
        BankAccount fd = new FixedDepositAccount("FD789", 10000, 12);
        savings.displayAccountType();
        checking.displayAccountType();
        fd.displayAccountType();
    }
}
