package savr.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private double amount;
    private String description;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }

    public String getTransactionType(){
        return type;
    }
    public double getTransactionAmount() {
        return amount;
    }
    public String getTransactionDescription() {
        return description;
    }
    public LocalDateTime getTransactionDate() {
        return dateTime;
    }
    public String toString() {
        return type + "|" + amount + "|" + description + "|" + dateTime;
    }
    public void setTransactionType(){
        this.type = type;
    }
    public void setTransactionAmount() {
        this.amount = amount;
    }
}

