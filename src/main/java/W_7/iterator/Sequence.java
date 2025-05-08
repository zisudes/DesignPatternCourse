package W_7.iterator;

import java.math.BigInteger;
import java.util.Iterator;

public interface Sequence {
    // using BigInteger instead of int to ensure that it works beyond numbers that are too large for int
    Iterator<BigInteger> iterator();
}
