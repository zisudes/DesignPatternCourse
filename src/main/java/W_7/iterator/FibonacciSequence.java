package W_7.iterator;

import java.math.BigInteger;
import java.util.Iterator;

public class FibonacciSequence implements Sequence {
    BigInteger previous;
    BigInteger next;
    BigInteger current;

    // storing data here instead of FibonacciIterator class
    // so it is independent of the iterator
    public FibonacciSequence() {
        this.previous = BigInteger.valueOf(0);
        this.current = BigInteger.valueOf(0);
        this.next = BigInteger.valueOf(1);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return new FibonacciIterator(this);
    }

    // calculation done here so that the variables stay truly private
    // inside the class
    public BigInteger getNextInSequence(){
        BigInteger cur = this.current;
        this.previous = this.current;
        this.current = this.next;
        this.next = this.previous.add(this.current);
        return cur;
    }
}
