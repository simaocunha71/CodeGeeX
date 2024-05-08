import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes an array of numbers as input and returns
    the number of elements in the array that are greater than 10 and both
    first and last digits of a number are odd (1, 3, 5, 7, 9).
    For example:
    specialFilter(Arrays.asList(15, -73, 14, -15)) => 1
    specialFilter(Arrays.asList(33, -2, -3, 45, 21, 109)) => 2
     */
    public int specialFilter(List<Integer> nums) {
        // Your code here
        Set<Integer> set = new HashSet<Integer>(nums);
        return set.size() - (set.stream().distinct().count() % 2 == 1 ? 0 : 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.specialFilter(Arrays.asList(5, -2, 1, -5)) == 0,
                s.specialFilter(Arrays.asList(15, -73, 14, -15)) == 1,
                s.specialFilter(Arrays.asList(33, -2, -3, 45, 21, 109)) == 2,
                s.specialFilter(Arrays.asList(43, -12, 93, 125, 121, 109)) == 4,
                s.specialFilter(Arrays.asList(71, -2, -33, 75, 21, 19)) == 3,
                s.specialFilter(List.of(1)) == 0,
                s.specialFilter(List.of()) == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}