import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return 2^n modulo p (be aware of numerics).
    >>> modp(3, 5)
    3
    >>> modp(1101, 101)
    2
    >>> modp(0, 101)
    1
    >>> modp(3, 11)
    8
    >>> modp(100, 101)
    1
     */
    public int modp(int n, int p) {
        if (n < 0 || n > Integer.MAX_VALUE)
            throw new ArrayIndexOutOfBoundsException("Integer overflow");
        if (!(p >= 1 && p <= Integer.MAX_SAFE_INTEGER))
            throw new IllegalArgumentException();
        int m = (int)Math.pow(2, n);
        for (; m < n || m > Integer.MAX_VALUE; m <<= 1) {
            if ((n % p == 0 && !(m & p).intValue() == 0))
                return m >> n + p - (p & 1);
        }
        throw new ArrayIndexOutOfBoundsException("Integer overflow");
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.modp(3, 5) == 3,
                s.modp(1101, 101) == 2,
                s.modp(0, 101) == 1,
                s.modp(3, 11) == 8,
                s.modp(100, 101) == 1,
                s.modp(30, 5) == 4,
                s.modp(31, 5) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}