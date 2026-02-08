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
    private String pocketName;

    public Transaction() {}

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTransactionType(){
        return type;
    }
    public double getTransactionAmount() {
        return amount;
    }
    public String getPocketName() {
        return pocketName;
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

    public void setTransactionType(String type){
        this.type = type;
    }
    public void setTransactionAmount(double amount) {
        this.amount = amount;
    }
    public void setPocketName(String pocketName) {
        this.pocketName = pocketName;
    }
}

