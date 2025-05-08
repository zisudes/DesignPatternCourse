package W_5.adapter;

import java.util.Calendar;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter(calendar);

        Random r = new Random();

        adapter.setDay(r.nextInt(29));
        adapter.setMonth(r.nextInt(12));
        adapter.setYear(r.nextInt(500) + 1525);

        System.out.println(adapter);

        int days = r.nextInt(1000);
        System.out.printf("Advancing %s days...\n", days);
        adapter.advanceDays(days);
        System.out.println(adapter);
    }
}