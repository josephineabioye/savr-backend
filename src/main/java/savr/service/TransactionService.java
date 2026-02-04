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
    public void logTransaction(String type, double amount, String pocketName) {
        Transaction tx = new Transaction();
        tx.setTransactionType(type);
        tx.setTransactionAmount(amount);
        if(pocketName != null && !pocketName.isEmpty()) {
            tx.setPocketName(pocketName);
        }
        transactionRepository.save(tx);
    }
    public void logTransaction(String type, double amount) {
        Transaction tx = new Transaction();
        tx.setTransactionType(type);
        tx.setTransactionAmount(amount);
        transactionRepository.save(tx);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAllByOrderByCreatedAtDesc();
    }
}
