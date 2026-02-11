package savr.service;

import org.springframework.stereotype.Service;
import savr.model.Account;
import savr.model.Pocket;

import java.util.List;
@Service
public class AccountService {
    private Account account;
    private final TransactionService transactionService;
    public AccountService(TransactionService transactionService) {
    this.account  = new Account("Main", 0);
        this.transactionService = transactionService;
    }
    public void deposit(double amount) {
        account.deposit(amount);
        transactionService.logTransaction("DEPOSIT", amount);
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (account.getAccountBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        account.withdraw(amount);
        transactionService.logTransaction("WITHDRAW", amount);
    }
    public String transferToPocket(String pocketName, double amount) {
        transactionService.logPocketTransaction("TRANSFER", amount, pocketName);
        return account.transferToPocket(pocketName, amount);
    }
    public double getBalance() {
        return account.getAccountBalance();
    }
    public List<Pocket> getPockets() {
        return account.pocketListName();
    }
}
