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
        
        int[] arr = new int[n];
        for (int i = 0;i < n;i++) {
            arr[i] = i * i - i + 1;
        }
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int j=0;j<=n-2;j++){
            
            if((arr[j]+arr[j+1]-3)%3 == 0){
                map.putIfAbsent(j, 0);
                count += map.get(j)+1;
            } else {
                    map.remove(j);
                }
        }
        
        return (int)count;
    }
}

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