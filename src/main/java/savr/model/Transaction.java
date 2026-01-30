package savr.model;

import java.time.LocalDateTime;

public class Transaction {
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
}
