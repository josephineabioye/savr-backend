package savr.controller;

import org.springframework.web.bind.annotation.*;
import savr.service.AccountService;

@RestController
@RequestMapping("/api/")

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService acctService) {
        accountService = acctService;
    }
    @GetMapping
    public String home() {
        return "Savr API is running";
    }
    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        accountService.deposit(amount);
        return "Deposited " + amount;
    }
    @GetMapping("/deposit-test")
    public String depositTest(@RequestParam double amount) {
        accountService.deposit(amount);
        return "Deposited " + amount + ", new balance: " + accountService.getBalance();
    }
    @GetMapping("/balance")
    public double balance() {
        return accountService.getBalance();
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount) {
        if(amount <= 0) {
            return "Amount must be greater than 0";
        }
        if(accountService.getBalance() < amount) {
          return "Insufficient Balance";
        }
            accountService.withdraw(amount);
        return "Withdrawn " + amount + ". New balance: " + accountService.getBalance();
    }
    @PostMapping("/transfer-pocket")
    public String transferToPocket(@RequestParam String pocketName, @RequestParam double amount) {
        String result = accountService.transferToPocket(pocketName, amount);
        return result + ". Current balance: " + accountService.getBalance();
    }

}
