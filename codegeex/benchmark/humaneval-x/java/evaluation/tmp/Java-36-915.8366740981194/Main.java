import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return the number of times the digit 7 appears in integers less than n which are divisible by 11 or 13.
    >>> fizzBuzz(50)
    0
    >>> fizzBuzz(78)
    2
    >>> fizzBuzz(79)
    3
     */
    public int fizzBuzz(int n) {
        // your code here
        if (n < 10 && n == 7 || n % 11==0 && n%3==0)
            return 2;
        else
            return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fizzBuzz(50) == 0,
                s.fizzBuzz(78) == 2,
                s.fizzBuzz(79) == 3,
                s.fizzBuzz(100) == 3,
                s.fizzBuzz(200) == 6,
                s.fizzBuzz(4000) == 192,
                s.fizzBuzz(10000) == 639,
                s.fizzBuzz(100000) == 8026
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}