package savr.model;
import java.util.*;

public class Account {
    private String name;
    private double balance;
    private List<Pocket> pockets;
    private List<Transaction> transactions;
    private List<AutoDebit> autoDebits;

    public Account(String name, double bal) {
        this.name = name;
        balance = bal;
        pockets = new ArrayList<>();
        transactions = new ArrayList<>();
        autoDebits = new ArrayList<>();
    }

    public String acctName(){
        return name;
    }

    public List<Pocket> pocketListName() {
        return pockets;
    }

    public double getAccountBalance(){
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        transactions.add(new Transaction("DEPOSIT", amount, "Deposit to account"));
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        transactions.add(new Transaction("WITHDRAW", amount, "Withdrawal from account"));
    }

    public void addPocket(Pocket pocket) {
        pockets.add(pocket);
    }
    public String transferToPocket(String pocketName, double amount) {
        if (amount <= 0) {
            return "Amount must be greater than zero.";
        }
        if (balance <= 0){
            return "Account is not Funded";
        }
        if (balance < amount){
            return "Insufficient account balance";
        }
        for (Pocket temp : pockets) {
            if (temp.getPocketName().equalsIgnoreCase(pocketName)) {
                String result = temp.addFunds(amount);
                balance -= amount;
                transactions.add(new Transaction("POCKET_TRANSFER",
                        amount, "Transfer to pocket: " + pocketName));
                return result;
            }
        }
        return "Pocket not found.";

    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addAutoDebit(AutoDebit rule) {
        autoDebits.add(rule);
    }

    public void runAutoDebits() {
        for (AutoDebit rule : autoDebits) {

            if (rule.isDue()) {

                String result = transferToPocket(rule.autoDebitPocketName(), rule.autoDebitAmount());

                if (result.toLowerCase().contains("credited")) {
                    rule.markExecuted();
                    System.out.println("Auto-debit successful for " + rule.autoDebitPocketName());
                } else {
                    System.out.println("Auto-debit failed for " + rule.autoDebitPocketName() + ": " + result);
                }
            }
        }
    }
    public String runSingleAutoDebit(String pocketName) {
        for (AutoDebit rule : autoDebits) {

            if (rule.autoDebitPocketName().equalsIgnoreCase(pocketName)) {

                double amount = rule.autoDebitAmount();

                if (balance < amount) {
                    return "Insufficient balance for auto-debit.";
                }

                String result = transferToPocket(pocketName, amount);
                return "Auto-debit result: " + result;
            }
        }

        return "Auto-debit rule not found.";
    }
}
