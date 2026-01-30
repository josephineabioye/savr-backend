package savr.model;

public class Pocket {
    private String name;
    private double targetAmount;
    private double currentAmount;

    public Pocket(String name, double tAmount){
        this.name = name;
        targetAmount = tAmount;
        currentAmount = 0;
    }

    public String getPocketName(){
        return name;
    }

    public double getTargetAmount(){
        return targetAmount;
    }

    public double getPocketBalance(){
        return currentAmount;
    }

    public String addFunds(double amount){
        if (currentAmount >= targetAmount) {
            return "Target already reached. No more funds can be added";
        }
        double remaining = targetAmount - currentAmount;

        if (amount > remaining){
            return "you can only add " + remaining + "to reach your target";
        }

        currentAmount += amount;
        if(currentAmount == targetAmount){
            return "Amount Credited!!";
        }
        return "Amount Credited Successfully!!";
    }

    public boolean isGoalReached(){
        return currentAmount >= targetAmount;
    }
}
