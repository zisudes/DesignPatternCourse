package W_3.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static String shortenArray(int[] array, int x) {
        int length = array.length;
        if (x * 2 >= length) {
            return Arrays.toString(array);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < x; i++) {
                sb.append(array[i]).append(", ");
            }
            sb.append("... ");
            for (int i = length - x; i < length; i++) {
                sb.append(array[i]);
                if (i < length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        SortingStrategy[] strats = {new JavaSort(), new CombSort(), new CycleSort(), new PigeonholeSort()};

        // adjust the size of the sortable array
        int n = 100000;

        int cutoff = 10;

        int[] orig = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) { orig[i] = random.nextInt(1000); }

        System.out.println("Starting array generated, size " + n + ":\n" + shortenArray(orig, 10) + "\n");

        List<Record> records = new ArrayList<>();

        for (SortingStrategy strat : strats) {
            int[] array = orig.clone();

            System.out.println("STARTING SORTING WITH STRATEGY: " + strat.getName());

            long startTime = System.nanoTime();
            System.out.println("Passing original array... " + shortenArray(array, cutoff));

            SortingContext sc = new SortingContext(strat);
            sc.sort(array);
            long time = (System.nanoTime() - startTime);
            System.out.println("Sorted array: " + shortenArray(array, cutoff));
            records.add(new Record(strat, time));
            System.out.println();
        }
        System.out.printf("%s name | %stime ns | %stime ms\n",
                " ".repeat(11),
                " ".repeat(8),
                " ".repeat(4));
        System.out.println("------------------------------------------------");
        records.forEach(Record::displayRecord);
    }
}