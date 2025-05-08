package W_7.iterator;

import java.math.BigInteger;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new FibonacciSequence();
        Iterator<BigInteger> iterator = sequence.iterator();
        int AMOUNT = 100;
        int round = 1;

        while (round <= AMOUNT & iterator.hasNext()) {
            System.out.println(round + ": " + iterator.next() + " ");
            round++;
        }
    }
}
