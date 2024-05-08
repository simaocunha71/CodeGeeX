import java.util.*;
import java.lang.*;

class Solution {
    /**
    Circular shift the digits of the integer x, shift the digits right by shift
    and return the result as a string.
    If shift > number of digits, return digits reversed.
    >>> circularShift(12, 1)
    "21"
    >>> circularShift(12, 2)
    "12"
     */
    public String circularShift(int x, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 13 - shift; i++) {
            int digit = (x%10) + '0'; // shift the digits right by shift and get the digits as an integer
            x = x / 10;                     // remove the shifting digits from x as an integer
            result.append(digit);
        }
        if (shift == 3) { // shift is 3, which means that we want to reverse the digits
            for (int i = 2; i >= 0; i--) {
                int digit = (x%10) + '0'; // shift the digits right by shift and get the digits as an integer
                x = x / 10;                     // remove the shifting digits from x as an integer
                result.append(digit);
            }
        } else {
            for (int i = 2; i >= 0; i--) {
                int digit = (x%10) + '0'; // shift the digits right by shift and get the digits as an integer
                x = x / 10;                     // remove the shifting digits from x as an integer
                result.append(digit);
            }
        }
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.circularShift(100, 2).equals("001"),
                s.circularShift(12, 2).equals("12"),
                s.circularShift(97, 8).equals("79"),
                s.circularShift(12, 1).equals("21"),
                s.circularShift(11, 101).equals("11")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}