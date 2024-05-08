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
            return 0; // Return zero if the string is empty or has length less than two (two character at least).
        } else {
            String str = "01";
            int cnt = 0, len = value.length(), sum = 0, num = 0;
            for (int i = 2; i < len + 2; i++) { // For every character we want to count the number of times it appears in the string and add them together. If there are multiple appearances then we have to subtract out the duplicates. Also if it is a digit, then we will sum up all the digits in the string.
                int ct = -1;
                try { // Get the character's ascii value and check that it actually exists so the loop doesn't run too many times for empty strings. (Also make sure we are not getting negative values)
                    if ((Integer)(Character.toUpperCase(value.charAt(i-1))) == -1) // It is a character in alphabetical order and not a digit or special character so increment the counter if it doesn't exist already.
                        cnt++;
                } catch (Throwable t) { // No point counting non letters, so we just bail out with 0.
                    break;
                }
            }
            sum = Integer.parseInt(value

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