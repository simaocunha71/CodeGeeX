import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function takes a list l and returns a list l' such that
    l' is identical to l in the indicies that are not divisible by three, while its values at the indicies that are divisible by three are equal
    to the values of the corresponding indicies of l, but sorted.
    >>> sortThird(Arrays.asList(1, 2, 3))
    [1, 2, 3]
    >>> sortThird(Arrays.asList(5, 6, 3, 4, 8, 9, 2))
    [2, 6, 3, 4, 8, 9, 5]
     */
    public List<Integer> sortThird(List<Integer> l) {
        // write your code here
        List<Integer> res = new ArrayList<>(l);
        for (int i=0;i<res.size();i+=3){
            if(!(i%3)) continue;
            int j = i + 1;
            while (!(j >= l.size()) && !(l.get(j-1) % 3 == 0)){
                res.set(i, l.get(j - 1));
                j++;
            }
        }
        return Collections.reverseOrder(res);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 3, 4, 8, 9, 2))).equals(Arrays.asList(2, 6, 3, 4, 8, 9, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 8, 3, 4, 6, 9, 2))).equals(Arrays.asList(2, 8, 3, 4, 6, 9, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 9, 4, 8, 3, 2))).equals(Arrays.asList(2, 6, 9, 4, 8, 3, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 3, 4, 8, 9, 2, 1))).equals(Arrays.asList(2, 6, 3, 4, 8, 9, 5, 1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}