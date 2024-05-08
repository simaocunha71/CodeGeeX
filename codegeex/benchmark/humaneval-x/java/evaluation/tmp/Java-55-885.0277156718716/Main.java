import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return n-th Fibonacci number.
    >>> fib(10)
    55
    >>> fib(1)
    1
    >>> fib(8)
    21
     */
    public int fib(int n) {
        if (n < 2) return 0;
        int f, s;
        f = s = 1;
        for (int i=1; i<n-1; i++) {
            f = s + f;
            s = f - s;
        }
        return f;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fib(10) == 55,
                s.fib(1) == 1,
                s.fib(8) == 21,
                s.fib(11) == 89,
                s.fib(12) == 144
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}