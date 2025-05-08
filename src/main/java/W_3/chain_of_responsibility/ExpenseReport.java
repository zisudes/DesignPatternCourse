package W_3.chain_of_responsibility;

public class ExpenseReport {
    private final double amount;
    private final boolean isPlanned;
    private boolean isApproved;

    public ExpenseReport(double amount, boolean isPlanned) {
        this.amount = amount;
        this.isPlanned = isPlanned;
        this.isApproved = false;
    }

    public double getAmount(){ return this.amount; };
    public boolean isPlanned(){ return this.isPlanned; };
    public boolean isApproved() { return isApproved; }
    public void setApproved(boolean isApproved) { this.isApproved = isApproved; }
}
