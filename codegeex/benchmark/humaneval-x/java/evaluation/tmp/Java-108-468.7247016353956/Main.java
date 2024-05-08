import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function countNums which takes an array of integers and returns
    the number of elements which has a sum of digits > 0.
    If a number is negative, then its first signed digit will be negative:
    e.g. -123 has signed digits -1, 2, and 3.
    >>> countNums(Arrays.asList()) == 0
    >>> countNums(Arrays.asList(-1, 11, -11)) == 1
    >>> countNums(Arrays.asList(1, 1, 2)) == 3
     */
    public int countNums(List<Integer> arr) {
        if (arr.isEmpty()) return 0;
        
        Set<Integer> temp = new HashSet<>();
        for (int a : arr) {
            long sumDigits = 1L;
            while (a >= 10 && a > 0) {
                a /= 10;
                sumDigits *= 10;
            }
            
            if (sumDigits == 0 || sumDigits % 10 != 0) continue;
            temp.add(a);
        }
        return temp.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countNums(List.of()) == 0,
                s.countNums(Arrays.asList(-1, -2, 0)) == 0,
                s.countNums(Arrays.asList(1, 1, 2, -2, 3, 4, 5)) == 6,
                s.countNums(Arrays.asList(1, 6, 9, -6, 0, 1, 5)) == 5,
                s.countNums(Arrays.asList(1, 100, 98, -7, 1, -1)) == 4,
                s.countNums(Arrays.asList(12, 23, 34, -45, -56, 0)) == 5,
                s.countNums(Arrays.asList(-0, (int) Math.pow(1, 0))) == 1,
                s.countNums(List.of(1)) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}