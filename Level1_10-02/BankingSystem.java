// Abstract class BankAccount
import java.util.*;
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public abstract double calculateInterest();
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;
    private double loanEligibilityAmount;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.loanEligibilityAmount = balance * 2; // Example rule: Loan eligibility is twice the balance
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility() && amount <= loanEligibilityAmount) {
            System.out.println("Loan of $" + amount + " approved for account: " + getAccountNumber());
        } else {
            System.out.println("Loan application denied for account: " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 1000; // Example condition for loan eligibility
    }
}

// Main class

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA123", "Alice", 5000));
        accounts.add(new CurrentAccount("CA456", "Bob", 8000));

        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName() + " | Interest Earned: $" + account.calculateInterest());
            
            if (account instanceof CurrentAccount) {
                ((CurrentAccount) account).applyForLoan(10000);
            }
        }
    }
}

