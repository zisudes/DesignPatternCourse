package W_7.iterator;

import java.math.BigInteger;
import java.util.Iterator;

public class FibonacciIterator implements Iterator<BigInteger> {
    private final FibonacciSequence sequence;

    public FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        return sequence.getNextInSequence();
    }
}
