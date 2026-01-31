package savr.service;

import savr.model.Account;
import savr.model.Pocket;

import java.util.List;

public class AccountService {
    private Account account = new Account("Main", 0);

    public void deposit(double amount) {
        account.deposit(amount);
    }
    public double getBalance() {
        return account.getAccountBalance();
    }
    public List<Pocket> getPockets() {
        return account.pocketListName();
    }
}
