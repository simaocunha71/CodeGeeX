import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return sorted unique elements in a list
    >>> unique(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))
    [0, 2, 3, 5, 9, 123]
     */
    public List<Integer> unique(List<Integer> l) {
        Set<Integer> s = new HashSet<>();
        for (int i : l) s.add(i);
        return new ArrayList<>(s);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.unique(new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))).equals(Arrays.asList(0, 2, 3, 5, 9, 123))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}