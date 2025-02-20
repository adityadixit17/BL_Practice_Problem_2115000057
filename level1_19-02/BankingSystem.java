import java.util.*;

class BankingSystem {
    private final HashMap<Integer, Double> accounts; 
    private final Queue<Integer> withdrawalQueue;  

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Withdrawal processed for Account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " - Balance: $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(101, 5000.00);
        bank.createAccount(102, 1200.50);
        bank.createAccount(103, 7500.75);
        bank.createAccount(104, 3000.00);

        bank.deposit(101, 1000.00);
        bank.deposit(103, 250.00);

        bank.requestWithdrawal(102);
        bank.requestWithdrawal(104);

        bank.processWithdrawals();

        bank.displaySortedAccounts();
    }
}
