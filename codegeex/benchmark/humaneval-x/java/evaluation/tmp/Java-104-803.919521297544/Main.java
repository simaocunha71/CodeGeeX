import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a list of positive integers x. return a sorted list of all
    elements that hasn't any even digit.

    Note: Returned list should be sorted in increasing order.
    
    For example:
    >>> uniqueDigits(Arrays.asList(15, 33, 1422, 1))
    [1, 15, 33]
    >>> uniqueDigits(Arrays.asList(152, 323, 1422, 10))
    []
     */
    public List<Integer> uniqueDigits(List<Integer> x) {
        Set<Integer> set = new HashSet<>();
        
        // add any even number to the set.
        if (x.size() == 0) {
            return Collections.synchronizedList(new ArrayList<>());
        }
        for (int i : x) {
            if (!set.add(i)) {
                // only once
                x = Collections.synchronizedList(new ArrayList<>(x));
                break;
            }
        }
        return x;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.uniqueDigits(Arrays.asList(15, 33, 1422, 1)).equals(Arrays.asList(1, 15, 33)),
                s.uniqueDigits(Arrays.asList(152, 323, 1422, 10)).equals(List.of()),
                s.uniqueDigits(Arrays.asList(12345, 2033, 111, 151)).equals(Arrays.asList(111, 151)),
                s.uniqueDigits(Arrays.asList(135, 103, 31)).equals(Arrays.asList(31, 135))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}