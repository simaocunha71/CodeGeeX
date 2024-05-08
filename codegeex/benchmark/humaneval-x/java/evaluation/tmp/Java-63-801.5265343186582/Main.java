import java.util.*;
import java.lang.*;

class Solution {
    /**
    The FibFib number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fibfib(0) == 0
    fibfib(1) == 0
    fibfib(2) == 1
    fibfib(n) == fibfib(n-1) + fibfib(n-2) + fibfib(n-3).
    Please write a function to efficiently compute the n-th element of the fibfib number sequence.
    >>> fibfib(1)
    0
    >>> fibfib(5)
    4
    >>> fibfib(8)
    24
     */
    public int fibfib(int n) {
        if (n < 3) return n;
        else if ((n > 3 && n % 3 != 0)) {
            String[] firstThree = new String[3];
            for (int i = 0; i < 3; i++) {
                if (i == 2 || i + 1 >= n)
                    return fibfib(n - 1);
                else if (i != 0 && i % 2 == 0)
                    return firstThree[2] = fibfib(n - 2);
                else {
                    String tempStr;
                    for (int j = 0; j < 3; j++) {
                        if ((j + 1 >= n || i != 0 && j % 2 == 0) && j == 2
                            && (tempStr = fibfib(n - 1)) != null)
                            firstThree[i] = new StringBuffer();
                    }
                }
            }
        } else {
            return fibfib(n);
        }
        for (int i = 0; i < 3; i++)
            System.out.println((!firstThree[0].equals("-2")) ? " fibfib(" + n + ")" : "-"
                + firstThree[i] + ", ");
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fibfib(2) == 1,
                s.fibfib(1) == 0,
                s.fibfib(5) == 4,
                s.fibfib(8) == 24,
                s.fibfib(10) == 81,
                s.fibfib(12) == 274,
                s.fibfib(14) == 927
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}