import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that takes a value (string) representing a number
    and returns the closest integer to it. If the number is equidistant
    from two integers, round it away from zero.

    Examples
    >>> closest_integer("10")
    10
    >>> closest_integer("15.3")
    15

    Note:
    Rounding away from zero means that if the given number is equidistant
    from two integers, the one you should return is the one that is the
    farthest from zero. For example closest_integer("14.5") should
    return 15 and closest_integer("-14.5") should return -15.
     */
    public int countUpper(String value) {
        if (value == null || value.length() < 2) {
            throw new IllegalArgumentException("Input is invalid");
        }
        
        Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().toLowerCase().charAt(0);
        return (ch == 'a' || ch == 'A') ? 1 : 2;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countUpper("10") == 10,
                s.countUpper("14.5") == 15,
                s.countUpper("-15.5") == -16,
                s.countUpper("15.3") == 15,
                s.countUpper("0") == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}