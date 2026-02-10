package savr.service;

import org.springframework.stereotype.Service;
import savr.model.Transaction;
import savr.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public void logTransaction(String type, double amount) {
        String description = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " transaction";
        Transaction tx = new Transaction(type, amount, description);
        transactionRepository.save(tx);
    }
    public void logPocketTransaction(String type, double amount, String description) {
        Transaction tx = new Transaction(type, amount, description);
        tx.setTransactionType(type);
        tx.setTransactionAmount(amount);
        if(tx.getPocketName() != null && !tx.getPocketName().isEmpty()) {
            tx.setPocketName(tx.getPocketName());
        }
        transactionRepository.save(tx);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAllByOrderByDateTimeDesc();
    }
}
