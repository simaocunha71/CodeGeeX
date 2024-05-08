import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return maximum element in the list.
    >>> maxElement(Arrays.asList(1, 2, 3))
    3
    >>> maxElement(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))
    123
     */
    public int maxElement(List<Integer> l) {
        if (l.size() == 0) return 0;
        Arrays.sort(l);
        // find the first element that isn't positive
        for (int i=1, j=l.get(i).compareTo(l.get(i-1)); i<l.size(); i++) {
            if (!j) break;
            j = l.get(i+1).compareTo(l.get(i));
        }
        // if the first element is positive, return it
        if (j > 0) return l.get(i-1);
        
        // otherwise return the last one
        int res = -1;
        for (int i=l.size()-2, j=l.get(i).compareTo(l.get(i+1)); i>0; --i) {
            if (!j) break;
            j = l.get(i+1).compareTo(l.get(i));
        }
        
        return res < 0 ? -1 : res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.maxElement(new ArrayList<>(Arrays.asList(1, 2, 3))) == 3,
                s.maxElement(new ArrayList<>(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10))) == 124
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}