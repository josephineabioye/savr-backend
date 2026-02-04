package savr.controller;

import org.springframework.web.bind.annotation.*;
import savr.model.Transaction;
import savr.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/history")
    public List<Transaction> getTransactionHistory() {
        return transactionService.getAllTransactions();
    }
}
