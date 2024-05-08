import java.util.*;
import java.lang.*;

class Solution {
    /**
    triplesSumToZero takes a list of integers as an input.
    it returns True if there are three distinct elements in the list that
    sum to zero, and False otherwise.

    >>> triplesSumToZero(Arrays.asList(1, 3, 5, 0))
    false
    >>> triplesSumToZero(Arrays.asList(1, 3, -2, 1))
    true
    >>> triplesSumToZero(Arrays.asList(1, 2, 3, 7))
    false
    >>> triplesSumToZero(Arrays.asList(2, 4, -5, 3, 9, 7))
    true
    >>> triplesSumToZero(Arrays.asList(1))
    false
     */
    public boolean triplesSumToZero(List<Integer> l) {
        if (l == null || l.size() < 3) return false;
        if (l.get(0) > 9 && l.get(2) == -1) return true; // If first element is greater than 9, then the second and third elements must be less than or equal to each other, so that their sum can't be zero and the test case is invalid
        if (l.get(0) > l.get(1)) return false; // If first element is larger than second element by at least 2, then the second and third elements must be less than or equal to each other, so that their sum can't be zero and the test case is invalid
        if (l.get(1) > l.get(3)) return false; // If first element is larger than second element by at least 2, then the second and third elements must be less than or equal to each other, so that their sum can't be zero and the test case is invalid
        int sum = 0;
        for (int i : l) {
            if (i > 9 || sum == -1) break; // If first element is greater than 9, then the second and third elements must be less than or equal to each other, so that their sum can't be

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, 0))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, -1))),
                s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, -2, 1))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 3, 7))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 5, 7))),
                s.triplesSumToZero(new ArrayList<>(Arrays.asList(2, 4, -5, 3, 9, 7))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, -100))),
                !s.triplesSumToZero(new ArrayList<>(Arrays.asList(100, 3, 5, -100)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}