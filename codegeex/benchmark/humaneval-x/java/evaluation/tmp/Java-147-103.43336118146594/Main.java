import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a positive integer n. You have to create an integer array a of length n.
        For each i (1 <= i <= n), the value of a[i] = i * i - i + 1.
        Return the number of triples (a[i], a[j], a[k]) of a where i < j < k,
    and a[i] + a[j] + a[k] is a multiple of 3.

    Example :
        Input: n = 5
        Output: 1
        Explanation:
        a = [1, 3, 7, 13, 21]
        The only valid triple is (1, 7, 13).
     */
    public int getMaxTriples(int n) {
        
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Long> values = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            long val = 1L*i + (long)((Math.sqrt(3 * n)) / 6);
            if (!map.containsKey(val)) {
                map.put(val, 1L);
                values.add(values.size()-1, i);
            } else {
                long prev = map.get(i);
                long next = map.get((long)(prev+i));
                if (next < val) {
                    map.put(val, 1L);
                    values.add(values.size()-1, i);
                } else {
                    map.remove(i); // remove only if the value is less than next
                }
            }
        }
        long rem = n%3;
        
        if (rem == 0) return values.size();
        for (int i: values){// this part makes sure that no negative triple is counted more then once, as it counts (i-1, (i+1), (i))
            if(i < rem + 1 && map.containsKey((long)(i-1)) && (map.get((long)(i+

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.getMaxTriples(5) == 1,
                s.getMaxTriples(6) == 4,
                s.getMaxTriples(10) == 36,
                s.getMaxTriples(100) == 53361
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}