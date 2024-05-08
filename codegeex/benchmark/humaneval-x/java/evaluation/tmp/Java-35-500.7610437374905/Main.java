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
        if (l.isEmpty()) return -1;
        ListIterator<Integer> p = l.listIterator();
        while (p.hasNext() && !l.isEmpty()){
            int n = 0, m = Integer.MIN_VALUE;
            for(int i=0;i<l.size();i++){
                if((p.next())>=m) p.set(n);
                else{
                    n++;
                    m=Math.max(n,m);
                }
            }
        return Integer.valueOf(m);
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