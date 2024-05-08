import java.util.*;
import java.lang.*;

class Solution {
    /**
    Complete the function that takes two integers and returns
    the product of their unit digits.
    Assume the input is always valid.
    Examples:
    multiply(148, 412) should return 16.
    multiply(19, 28) should return 72.
    multiply(2020, 1851) should return 0.
    multiply(14,-15) should return 20.
     */
    public int multiply(int a, int b) {
        if (a == -1 || b == -1) return 1;
        else if (a <= 9 && b < 10) return 10 * a * b;
        else if (a >= 10 && b > 9 ) return 10*Math.pow(a,9)*b;
        else {
            int p = multiply(-1,-1);
            int product = Math.abs(multiply(a,b));
            if (p == -1) return product;
            else if (product < 100000 && a != b) return 10 * a * b;
            else return multiply(Math.pow(-1,(int)(9-((double)a)/10)), Math.pow((double)-1, (int)((double)b/10)));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.multiply(148, 412) == 16,
                s.multiply(19, 28) == 72,
                s.multiply(2020, 1851) == 0,
                s.multiply(14,-15) == 20,
                s.multiply(76, 67) == 42,
                s.multiply(17, 27) == 49,
                s.multiply(0, 1) == 0,
                s.multiply(0, 0) == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}