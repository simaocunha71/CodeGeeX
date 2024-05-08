import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function takes a list l and returns a list l' such that
    l' is identical to l in the odd indicies, while its values at the even indicies are equal
    to the values of the even indicies of l, but sorted.
    >>> sortEven(Arrays.asList(1, 2, 3))
    [1, 2, 3]
    >>> sortEven(Arrays.asList(5, 6, 3, 4))
    [3, 6, 5, 4]
     */
    public List<Integer> sortEven(List<Integer> l) {
        //Write your code here
        int n = l.size();
        
        
        if (n % 2 != 0){
            System.out.println("ERROR");
             return null;
        }
        
        for (int i=1;i<n/2+1;++i) {
            Integer current = l.get(i);
            
            if (current == null || current < 0) {
                break;
            }
            
            l.set(i, l.subList(i, n).stream().sorted().findAny().orElse(-1));
        }
        
        return l;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortEven(new ArrayList<>(Arrays.asList(1, 2, 3))).equals(Arrays.asList(1, 2, 3)),
                s.sortEven(new ArrayList<>(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))).equals(Arrays.asList(-10, 3, -5, 2, -3, 3, 5, 0, 9, 1, 123)),
                s.sortEven(new ArrayList<>(Arrays.asList(5, 8, -12, 4, 23, 2, 3, 11, 12, -10))).equals(Arrays.asList(-12, 8, 3, 4, 5, 2, 12, 11, 23, -10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}