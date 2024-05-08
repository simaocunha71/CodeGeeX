import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function which returns the largest index of an element which
    is not greater than or equal to the element immediately preceding it. If
    no such element exists then return -1. The given array will not contain
    duplicate values.

    Examples:
    canArrange(Arrays.asList(1,2,4,3,5)) = 3
    canArrange(Arrays.asList(1,2,3)) = -1
     */
    public int canArrange(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return -1;
        int lastNegOne = -1;
        for (int index : arr) {
            if (!index.equals(lastNegOne)) {
                lastNegOne = index;
            } else {
                continue;
            }
        }
        return lastNegOne;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.canArrange(Arrays.asList(1, 2, 4, 3, 5)) == 3,
                s.canArrange(Arrays.asList(1, 2, 4, 5)) == -1,
                s.canArrange(Arrays.asList(1, 4, 2, 5, 6, 7, 8, 9, 10)) == 2,
                s.canArrange(Arrays.asList(4, 8, 5, 7, 3)) == 4,
                s.canArrange(List.of()) == -1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}