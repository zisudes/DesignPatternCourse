package W_3.chain_of_responsibility;

import java.util.Scanner;

public class ManualApprover extends Approver{
    public ManualApprover() {}

    @Override
    public void process(ExpenseReport report) {
        System.out.println((report.isPlanned() ? "Planned" : "Unplanned") +
                    " report of " + report.getAmount() +
                    " euros in processing, needs manual approval.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Approve? (Y/N)");
            if (scanner.nextLine().equalsIgnoreCase("y")){
                report.setApproved(true);
                System.out.println("Report approved.");
            } else {
                report.setApproved(false);
                System.out.println("Report not approved.");
            }
    }
}
