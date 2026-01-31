package savr.service;

import org.springframework.stereotype.Service;
import savr.model.Account;
import savr.model.Pocket;

import java.util.List;
@Service
public class AccountService {
    private Account account;
    public AccountService() {
    this.account  = new Account("Main", 0);
    }
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
