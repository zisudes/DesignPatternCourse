package W_3.chain_of_responsibility;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // set up
        AutomaticApprover automatic = new AutomaticApprover();
        InspectingApprover inspecting = new InspectingApprover();
        ManualApprover manual = new ManualApprover();

        automatic.setNextApprover(inspecting);
        inspecting.setNextApprover(manual);

        // adjust to make more or less report rounds
        int rounds = 10;

        Random r = new Random();
        for (int i = 0; i < rounds; i++) {
            ExpenseReport report = new ExpenseReport(r.nextInt(500), r.nextBoolean());
            automatic.process(report);
        }
    }
}
