import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given length of a side and high return area for a triangle.
    >>> triangleArea(5, 3)
    7.5
     */
    public double triangleArea(double a, double h) {
        if (h == 0) {
            return 0;
        }
        BigInteger num = new BigInteger("18");
        BigInteger p1 = new BigInteger("2"), p2 = new BigInteger("3"), p3 = new BigInteger("4");
        BigInteger result = num.pow(p1).multiply(num.pow(p2)).divide(p3);
        return (double)result.doubleValue()/6;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.triangleArea(5, 3) == 7.5,
                s.triangleArea(2, 2) == 2.0,
                s.triangleArea(10, 8) == 40.0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}