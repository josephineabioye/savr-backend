package savr.model;

import java.time.LocalDate;

public class AutoDebit {
    private String pocketName;
    private double amount;
    private Frequency frequency;

    private LocalDate lastRun;
    private LocalDate nextRun;

    public AutoDebit(String pName, double amt, Frequency frequency) {
        pocketName = pName;
        amount = amt;
        this.frequency = frequency;
        this.lastRun = null;
        this.nextRun = calculateNextRun(LocalDate.now());
    }
    public AutoDebit(String pocketName, double amount, Frequency frequency,
                     LocalDate lastRun, LocalDate nextRun) {
        this.pocketName = pocketName;
        this.amount = amount;
        this.frequency = frequency;
        this.lastRun = lastRun;
        this.nextRun = nextRun;
    }

    public String autoDebitPocketName() {
        return pocketName;
    }

    public double autoDebitAmount() {
        return amount;
    }
    private LocalDate calculateNextRun(LocalDate fromDate) {
        switch (frequency) {
            case DAILY:
                return fromDate.plusDays(1);
            case WEEKLY:
                return fromDate.plusWeeks(1);
            case MONTHLY:
                return fromDate.plusMonths(1);
            default:
                return fromDate.plusDays(1);
        }
    }
    public boolean isDue() {
        return !LocalDate.now().isBefore(nextRun);
    }
    public void markExecuted() {
        lastRun = LocalDate.now();
        nextRun = calculateNextRun(lastRun);
    }
    public String toFileString() {
        return pocketName + ", " +
                amount + ", " +
                frequency + ", " +
                lastRun + ", " +
                nextRun;
    }
}
