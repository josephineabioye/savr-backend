package savr.controller;

import org.springframework.web.bind.annotation.*;
import savr.service.AccountService;

@RestController
@RequestMapping("/api/account")

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService acctService) {
        accountService = acctService;
    }
    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        accountService.deposit(amount);
        return "Deposited " + amount;
    }
    @GetMapping("/balance")
    public double balance() {
        return accountService.getBalance();
    }
}
