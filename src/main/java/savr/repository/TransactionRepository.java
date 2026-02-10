package savr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import savr.model.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByOrderByDateTimeDesc();
}
