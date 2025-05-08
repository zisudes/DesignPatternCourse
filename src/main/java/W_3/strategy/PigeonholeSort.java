package W_3.strategy;

import java.util.Arrays;

public class PigeonholeSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for (int k : arr) {
            if (k > max)
                max = k;
            if (k < min)
                min = k;
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i<n; i++)
            phole[arr[i] - min]++;


        index = 0;

        for(j = 0; j<range; j++)
            while(phole[j]-->0)
                arr[index++]=j+min;
    }

    @Override
    public String getName() {
        return "PigeonholeSort";
    }
}
