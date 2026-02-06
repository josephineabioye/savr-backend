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
    public void logTransaction(String type, String description, double amount) {
        Transaction tx = new Transaction(type, amount, description);
        tx.setTransactionType();
        tx.setTransactionAmount();
        if(tx.getPocketName() != null && !tx.getPocketName().isEmpty()) {
            tx.setPocketName();
        }
        transactionRepository.save(tx);
    }
    public void logTransaction(String type, double amount, String description) {
        Transaction tx = new Transaction(description, amount, type);
        transactionRepository.save(tx);
    }
    public void logTransaction(String description, double amount ) {
        Transaction tx = new Transaction("DEPOSIT", amount, description);
        transactionRepository.save(tx);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAllByOrderByCreatedAtDesc();
    }
}
