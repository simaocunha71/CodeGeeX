import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input is a space-delimited string of numberals from 'zero' to 'nine'.
    Valid choices are 'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight' and 'nine'.
    Return the string with numbers sorted from smallest to largest
    >>> sortNumbers("three one five")
    "one three five"
     */
    public String sortNumbers(String numbers) {
        if (numbers == null || numbers.length() == 0) return "";
        for (int i = 1; i < numbers.length(); i++)
            for (int j = i-1; j >= 0 && (Character.isDigit(numbers.charAt(j)) && Character.isDigit(numbers.charAt(i))); j--)
                if (Character.digit(numbers.charAt(i), 10) > Character.digit(numbers.charAt(j), 10)) {
                    char temp = numbers.charAt(i);
                    numbers.replace(temp, Character.toLowerCase(temp));
                } else {
                    break;
                }
        return numbers;
        
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortNumbers("").equals(""),
                s.sortNumbers("three").equals("three"),
                s.sortNumbers("three five nine").equals("three five nine"),
                s.sortNumbers("five zero four seven nine eight").equals("zero four five seven eight nine")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}