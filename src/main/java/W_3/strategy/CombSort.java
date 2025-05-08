package W_3.strategy;
public class CombSort implements SortingStrategy {
    // CombSort from GeeksForGeeks
    // https://www.geeksforgeeks.org/comb-sort/

    private int getNextGap(int gap){
        gap = (gap*10)/13;
        return Math.max(gap, 1);
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;
        int gap = getNextGap(n);
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "CombSort";
    }
}
