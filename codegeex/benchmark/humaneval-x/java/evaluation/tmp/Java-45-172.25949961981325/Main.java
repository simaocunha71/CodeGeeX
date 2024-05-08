import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given length of a side and high return area for a triangle.
    >>> triangleArea(5, 3)
    7.5
     */
    public double triangleArea(double a, double h) {
        if (a < 0 || h < 0) throw new RuntimeException("One or more of the parameters is negative: " + Arrays.toString(a));
        
        final double PI = Math.PI;
        final double SQR_256 = 16;
        final int RADIANS = 180 / PI;
        return a * (h / (SQR_256 + (a - h) * RADIANS));
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("triangleArea(10, 3) is " + solution.triangleArea(10, 3));
        System.out.println("triangleArea(5, 3) is " + solution.triangleArea(5, 3));
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