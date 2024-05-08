import java.util.*;
import java.lang.*;

class Solution {
    /**
    A simple program which should return the value of x if n is
    a prime number and should return the value of y otherwise.

    Examples:
    for xOrY(7, 34, 12) == 34
    for xOrY(15, 8, 5) == 5
     */
    public int xOrY(int n, int x, int y) {
        if (n % x != 0 && n % y != 0 ) return Math.max(x,y);
        if (n % x > 0 && n % x == 1) return n - n % x;
        else return n / y + 2 * y; //return value of x which is evenly divisible by y
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.xOrY(7, 34, 12) == 34,
                s.xOrY(15, 8, 5) == 5,
                s.xOrY(3, 33, 5212) == 33,
                s.xOrY(1259, 3, 52) == 3,
                s.xOrY(7919, -1, 12) == -1,
                s.xOrY(3609, 1245, 583) == 583,
                s.xOrY(91, 56, 129) == 129,
                s.xOrY(6, 34, 1234) == 1234,
                s.xOrY(1, 2, 0) == 0,
                s.xOrY(2, 2, 0) == 2
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}